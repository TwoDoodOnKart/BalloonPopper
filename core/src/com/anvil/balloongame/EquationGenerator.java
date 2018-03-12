package com.anvil.balloongame;

/**
 * The EquationGenerator class is used to generate a simple arithmetic equation.
 * Depending on the difficulty selected by the user, there will be 2 (easy), 3
 * (medium), or 4 (hard) terms added/subtracted in the equation.
 * 
 * <p>
 * <b> Instance Variables </b>
 * <p>
 * <b> level </b> int variable that stores the difficulty level selected by the
 * user.
 * <p>
 * <b> answer </b> int variable that stores the answer to the randomly generated
 * math equation.
 * <p>
 * <b> equation </b> String variable that stores the randomly generated math
 * equation.
 * 
 * @author I Wong and E Wang
 * @version 1 05.12.16
 * 
 */
public class EquationGenerator {
 private int level = 0;
 private int answer = 0;
 private String equation = "";

 /**
  * The EquationGenerator constructor is accessed when the EquationGenerator
  * class is instantiated. The constructor assigns a value to variable level,
  * and calls the setAnswer (level) method to generate a random math
  * equation.
  * 
  * @param level
  *            | int value that stores the difficulty level selected by the
  *            user.
  */

 public EquationGenerator (int level) {
  this.level = level;
  setAnswer (level);
 }

 /**
  * Access method getAnswer () returns the value of the answer to the
  * randomly generated math equation.
  * 
  * @return answer | returns the value of answer.
  */

 public int getAnswer () {
  return answer;
 }

 /**
  * The method setAnswer (int level) is used to generate a math equation with
  * a certain number of terms. If hard mode was selected, the maximum value
  * of the answer to the equation can be 10, otherwise the maximum value is
  * 12. A while loop is used to continuously generate equations until the
  * equation produced has an answer that is greater than 0 and is smaller or
  * equal to the maximum value. The first term of the equation is set before
  * entering the for loop, and this term is added to the equation string. The
  * level selected determines the number of terms in the equation and also
  * the number of times the forloop runs. In the forloop, a random number
  * generator returns either 1 or 2. If it is 1, a random number is added to
  * the equation/answer. If it is 2, a random number is subtracted from the
  * equation/answer. As these loops run, more terms and symbols are added to
  * the equation, and the answer to the equation is altered accordingly.
  * 
  * <p>
  * <b> Local Variables </b>
  * <p>
  * <b> function </b> int variable that determines whether to add/subtract.
  * <p>
  * <b> tempAnswer </b> int variable that stores the answer to the temporary
  * equation (as more terms are added/subtracted).
  * <p>
  * <b> tempNum </b> int variable that stores a random number that is
  * added/subtracted.
  * <p>
  * <b> maxVal </b> int variable that stores the maximum value of the answer
  * of the randomly generated equation.
  * <p>
  * <b> Conditional Statements </b>
  * <p>
  * <b> 1st Statement </b> Determines whether to add/subtract from the
  * answer/in the equation.
  * <p>
  * <b> 2nd Statement </b> Determines whether the generated equation is
  * acceptable (greater than 0, smaller than the maximum value.
  * 
  * @param level
  *            | int value that stores the difficulty level selected.
  */

 public void setAnswer (int level) {
  int function = 0;
  int tempAnswer = 0;
  int tempNum = 0;
  int maxVal = 12;
  if (level == 3) {
   maxVal = 10;
  }
  while (true) {
   equation = "";
   tempAnswer = (int) (Math.random () * (maxVal) + 1);
   equation += Integer.toString (tempAnswer);
   for (int i = 0; i < level; i++) {
    function = (int) (Math.random () * (2) + 1);
    tempNum = (int) (Math.random () * (maxVal) + 1);
    if (function == 2) {
     tempAnswer = tempAnswer - tempNum;
     equation += "-" + Integer.toString (tempNum);
     break;
    } else {
     if (function == 1) {
      tempAnswer = tempAnswer + tempNum;
      equation += "+" + Integer.toString (tempNum);
      break;
     }
    }
   }
   if (tempAnswer <= maxVal && tempAnswer > 0)
    break;
   tempAnswer = 0;
  }
  answer = tempAnswer;
 }

 /**
  * Access method getEquation () returns the randomly generated math
  * equation.
  * 
  * @return equation | returns the equation in String format.
  */

 public String getEquation () // similiar to a toString method.
 {
  return equation;
 }
}