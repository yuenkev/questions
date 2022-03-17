/*
Author: Kevin Yuen
Student #: 991652450
Teacher: Muhammad Mohiuddin
Class: PROG24178 - JAVA 2 (OOP)
*/
package questions;

public enum QuestionType {

    //Enum constants for QuestionType
    TRUE_FALSE("True/False"),
    SHORT_ANSWER("Short Answer"),
    MULTIPLE_CHOICE("Multiple-Choice");

    //Data-Member of QuestionType
    private String type;

    /**
     *  Public Accessor Method.
     */
    
    public String getType(){
        return type;
    }

    /**
     *  Private Constructor that sets each type field value.
     * @param type
     */
    private QuestionType(String type){
        this.type = type;
    }

}
