/**
 * Put your JavaDocs here.
 *
 * @author Wendi Jollymore, updated by M. Mohiuddin on 3/1/18

 * @author Kevin Yuen
 */
package questions;
public class MCQuestion extends Question {

    private char answer = '.';   // the correct answer to this question
    private String[] options = null; // the list of multiple choice options
    
    /**
     * Constructs a default MC Question object.
     */
    public MCQuestion() {
        super();
        /* TODO MCQ.1.1: assign multiple choice question enum to the 
         questionType field here*/
        questionType = QuestionType.MULTIPLE_CHOICE;
    }

    /**
     * Constructs a MC Question object with a specific id, text, answer, and
     * list of options.
     *
     * @param id the question id
     * @param text the question text
     * @param answer the correct answer
     * @param ops the list of choice options
     */
    public MCQuestion(int id, String text, char answer, String... ops) {
        super(id, text);
        setOptions(ops);
        setAnswer(answer);
        /* TODO MCQ.1.2: assign multiple choice question enum to the 
         questionType field here*/
        questionType = QuestionType.MULTIPLE_CHOICE;
    }

    /**
     * Sets the answer member to a specific value.  The answer is the letter
     * of the multiple-choice option that has the correct answer to the
     * question.  The answer must be a letter and it must be in a valid
     * range (e.g. if there are 4 options, then the answer letter must be
     * a, b, c, or d).
     * 
     * @param answer this is questions correct answer
     * @throws IllegalArgumentException if the answer is not valid
     */
    public void setAnswer(char answer) throws IllegalArgumentException {
        // convert the answer to lower-case
        char a = Character.toLowerCase(answer);
        // subtract 97 to turn it into an index for the options array
        int index = a - 97;
         // if the answer is a letter and it's within the valid range of 
        // array indexes, set it
        if (Character.isLetter(a) && index >= 0 && index < options.length) {
            this.answer = a;
        } else { // invalid answer - throw exception
            throw new IllegalArgumentException(answer + " is not a valid answer option.");
        }
    }

    /**
     * Retrieves the correct answer letter for this question.
     * 
     * @return the questions correct answer
     */
    public char getAnswer() {
        return answer;
    }

    /* TODO MCQ.2.0: 
     * setOptions() mutator method:
     * Make sure that the variable argument list is not empty (length is not
     * 0 or less.  If it is, throw an IllegalArgumentException.
     * You also need to make sure that each element of the list has something
     * in it (no null-strings), othewise, throw an exception.  
     * If everything is ok, arraycopy() the list parameter contents into
     * the array data member options.
     * Don't forget the Javadocs and DON'T use the specs above in the Javadocs:
     * write friendly and professional docs in your own words.
     */
    public void setOptions(String...str) throws IllegalArgumentException{
       
        //Check for no elemets in the parameter variable-length list
        if(str.length <= 0){
            throw new IllegalArgumentException("No options added, yet!");
        }

        //For loop for the inputted variable-length diagram to check for empty lists/elements.
        for(String e: str){
            if(e == null || e.equals("")){
                throw new IllegalArgumentException("All Items in the list must contian a value.");
            }
        }

        options = new String[str.length];
        //Copying the valid inputted variable-length array into an array called "options"
        System.arraycopy(str, 0, this.options , 0, str.length);
    }


    /* TODO MCQ.3.0: 
     * getOptions() accessor method:
     * A bit more code than your typical accessor because you need to
     * return an arraycopy() of the options array.
     * Don't forget the Javadocs and DON'T use the specs above in the Javadocs:
     * write friendly and professional docs in your own words.
     */

     public String[] getOptions(){
        //Creates a copy of the array "options" and returns it
        String[] optionCopy = new String[options.length];
        System.arraycopy(options, 0, optionCopy, 0, options.length);
        return optionCopy;
     }


    /* TODO MCQ.4.0: 
     * isCorrect() override:
     * Check that the param is a String or Character (the programmer could
     * capture the user's answer using either one).  If it's not, then 
     * consider the answer incorrect.  Otherwise, convert the guess param
     * into a char and compare it to answer so you can return whether or
     * not the guess correct.
     * Don't forget the Javadocs and DON'T use the specs above in the Javadocs:
     * write friendly and professional docs in your own words.
     */

     @Override
     public boolean isCorrect(Object guess){
        boolean ob1 = false;
        
        //If guess (object) is NOT a String/Character then return false for the answer.
        if ((!(guess instanceof Character)) || (!(guess instanceof String))){
            ob1 = false;
        }

        //If the guess object is a String, check if inputted answer is correct by comparing it to the REAL answer
        if(guess instanceof String){
            if(answer == ((guess.toString()).charAt(0)));{
                ob1 = true;
            }
        }
    
        //If the guess object is a Char, check if inputted answer is correct by comparing it to the REAL answer
        if(answer == guess.toString().toLowerCase().charAt(0)){
                ob1 = true;
        } else {
                ob1 = false;
        }

        //Return a bolean stating if the MCQuestion is Correct.
        return ob1;
     }


    /* TODO MCQ.5.0: 
     * toString() override:
     * A String representation of a Multiple Choice question object will look
     * like this (the actual number of options could vary):
    #1: Which of the following is NOT a variety of grape used for white wine?
    a) Riesling
    b) Malbec
    c) Sauvingnon Blanc
    d) Gewürztraminer
    e) Chenin Blanc
    
     * Make sure there are elements in the options data member (it will be null).
     * If the options member has not been assigned options yet, use the text
     * "No options added, yet!" instead of any actual multiple choice options.
     *
     * Don't forget the Javadocs and DON'T use the specs above in the Javadocs:
     * write friendly and professional docs in your own words.
     *
     * HINT: you can increment a char and it will go to the next letter in the
     * alphabet e.g. char letter = 'a'; letter++ will store 'b' in letter. 
     */    

     @Override
     public String toString(){

        char letter = 'a';
        String choices = "";

        //This method/array shows the options of answers to the MCQuestion
        for(int i = 0; i < options.length; i++){
            choices += letter + ") " + options[i] + "\n";
            letter++;
        }
        
        //Check for Null options array and add requried string to return value.
        if(options == null){
            return String.format("No options added, yet!");
        } else {
            //return a formatted string contain all the multiple choice answers
            return String.format("%s%n%s", super.toString(), choices);
        }

     }

}
