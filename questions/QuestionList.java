/*
Author: Kevin Yuen
Student #: 991652450
Teacher: Muhammad Mohiuddin
Class: PROG24178 - JAVA 2 (OOP)
*/
package questions;

import java.util.ArrayList;

public class QuestionList extends ArrayList<Question>{
    /**
     * Default constructor for "QuestionList()"
     */
    public QuestionList(){
    }

    /**
     *One-arg Constructor for "QuestionsList()", that accepts a variable-length argument and add each Question Object to it's own QuestionList Object
     * 
     * @param q
     */
    public QuestionList(Question... q){
        //Cycles thru the variable-lenght questions obj and
        for(Question dex: q){
            this.add(dex);
        }
    }

    /**
     * Method that presents the Question ID, Question Text, and displays the prompt message "Answer: ";
     * 
     * @param index
     * @return
     */
    public String presentQuestion(int index){
        if (index >= this.size()){
            return null;
        } else {
            return String.format("%s%nAnswer: ", this.get(index));
        }
    }
}
