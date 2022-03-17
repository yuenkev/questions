/*
Author: Kevin Yuen
Student #: 991652450
Teacher: Muhammad Mohiuddin
Class: PROG24178 - JAVA 2 (OOP)
*/
package questions;
public abstract class Question {
    
    //Data types for "questionId" && "questionText".
    private int questionId;
    private String questionText;
    protected QuestionType questionType;

    //A#2 -----------------------

    // The protected modifier is used on members of a class that you want be accessible to
    // child/sub classes and classes in the same package.

    // --------------------------

    //Default Constructor for "Question()".
    public Question() {
        questionId = 1;
        setQuestionText("TBD");
    }

    /**
     * @param id
     * @param text
     * Constructor that call upon two setters.
     */
    public Question(int id, String text) {
        setQuestionId(id);
        setQuestionText(text);
    }

    /**
     * Setter for the data type "questionId" with data validation.
     * @param id
     * @throws IllegalArgumentException
     */
    public void setQuestionId(int id) throws IllegalArgumentException{
        if(id <= 0) {
            throw new IllegalArgumentException("Error: Question ID must be greater than 0.");
        } else {
            questionId = id;
        }
    }

    //Getter for the data type "questionId" that returns it's value.
    public int getQuestionId(){
        return questionId;
    }

    /**
     * Setter for the data type 'questionText', that has data validation.
     * @param text
     * @throws IllegalArgumentException
     */
    public void setQuestionText(String text) throws IllegalArgumentException{
        if (text == null || text.equals("")){
            throw new IllegalArgumentException("Error: Please enter in a question.");
        } else {
            questionText = text;
        }
    }

    //Getter for the data type "questionText" that returns it's value.
    public String getQuestionText(){
        return questionText;
    }

    /**
     * Abstract method in the superclass "Question.java" that returns a boolean value.
     * @param object
     * @return
     */
    public abstract boolean isCorrect(Object object);

    //Method that returns a String containing the data type values.
    public String toString(){
        if(questionText == "TBD") {
            return String.format("#%3d: %s", questionId, "No question text entered.");
        } else {
            return String.format("#%3d: %s", questionId, questionText);
        }
    }
}
