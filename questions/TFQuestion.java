/*
Author: Kevin Yuen
Student #: 991652450
Teacher: Muhammad Mohiuddin
Class: PROG24178 - JAVA 2 (OOP)
*/
package questions;
public class TFQuestion extends Question{
    
    //Data Type for the value answer.
    private boolean answer;

    //Default constructor for TFQuestion();
    public TFQuestion() {
        super();
        answer = false;
        questionType = QuestionType.TRUE_FALSE;
    }

    /**
     * Constructor that calls upon the superclasses' methods(get inheritted by this class(subclass)) and calls upon a setter for the param "answer".
     * @param id
     * @param text
     * @param answer
     */
    public TFQuestion(int id, String text, boolean answer){
        super(id, text);
        setAnswer(answer);
        questionType = QuestionType.TRUE_FALSE;
    }

    //Getter for the data type 'answer'.
    public boolean isAnswer(){
        return answer;
    }

    /**
     * Setter for the datatype 'answer'.
     * @param ans
     */
    public void setAnswer(boolean ans){
        answer = ans;
    }
    
    /**
     * Overridden method that returns a boolean value, depending on the if the answer matches.
     * @param guess
     */
    @Override
    public boolean isCorrect(Object guess){
        Boolean ob1 = true;

        if (guess instanceof Boolean){
            ob1 = (Boolean)guess; 
        }
        if (guess instanceof String){
            ob1 = Boolean.parseBoolean(guess.toString());
        }
        if (!(answer == ob1)){
            return false;
        }
        return true;
    }

    //Overriden toString() method that calls upon the superclasses' method(it's inheritted in this class).
    @Override
    public String toString(){
        return String.format("%s [true or false?]", super.toString());
    }
}
