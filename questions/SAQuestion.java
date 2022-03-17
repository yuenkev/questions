/*
Author: Kevin Yuen
Student #: 991652450
Teacher: Muhammad Mohiuddin
Class: PROG24178 - JAVA 2 (OOP)
*/
package questions;
public class SAQuestion extends Question{
    //Data type for 'answer';
    private String answer;

    //Default constructor calling upon the super class constructor + setting SAQuestion's data member.
    public SAQuestion(){
        super();
        this.answer = "TBD";
        questionType = QuestionType.SHORT_ANSWER;
    }

    /**
     * Constructor that calls up on the superclass constructor + calling a setter.
     * @param id
     * @param text
     * @param answer
     * @throws IllegalArgumentException
     */
    public SAQuestion(int id, String text, String answer) throws IllegalArgumentException{
        super(id, text);
        setAnswer(answer);
        questionType = QuestionType.SHORT_ANSWER;
    }

    //Getter for the "answer" contained in the inherited data type from the superclass.
    public String getAnswer(){
        return answer;
    }

    /**
     * Mutator for the data type "answer" with data validation.
     * @param ans
     * @throws IllegalArgumentException
     */
    public void setAnswer(String ans) throws IllegalArgumentException{
            if(ans == null || ans.equals("")){
                throw new IllegalArgumentException("Error. Answer must be entered.");
            } else {
                this.answer = ans;  
            }
    }

    /**
     * Overridden method that returns a boolean value, depending on the if the answer matches.
     * @param guess
     */
    @Override
    public boolean isCorrect(Object guess){
        String ob1 = guess.toString();

        if (!(answer.equalsIgnoreCase(ob1))) {
            return false;
        }  
        return true;
    }

    //Overriden toString() method that calls upon the superclasses' method(it's inheritted in this class).
    @Override
    public String toString(){
        return String.format("%s", super.toString());
    }
}