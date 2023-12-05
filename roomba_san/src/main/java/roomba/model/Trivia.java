package roomba.model;

/**
 * Contains Trivia, which contains a question and answer.
 */
public class Trivia {
    private String question;

    private String answer;

    /**
     * Instantiates a Trivia class with a question only.
     * @param question The question for the trivia class.
     */
    public Trivia(String question) {
        this.question = question;
    }

    /**
     * Instantiates a Trivia class with a question and answer.
     * @param question The question for the trivia class.
     * @param answer The answer for the trivia class.
     */
    public Trivia(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    /**
     * Adds an answer to a question, provided that the question has yet to be answered.
     * @param answer The answer to a question.
     */
    public void addAnswer(String answer) {
        if (answer == null) {
            this.answer = answer;
        }
    }

    /**
     * Check if the current instance of trivia has been answered.
     * @return Whether the trivia has an answer.
     */
    public boolean hasAnswer() {
        return this.answer != null;
    }

    /**
     * Checks if an object is equal to an instance of the Trivia class.
     * @param obj The object in question.
     * @return Whether the object is equivalent to an instance of this class.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Trivia) {
            if (obj == this) {
                return true;
            }

            Trivia otherTrivia = (Trivia) obj;

            return otherTrivia.question.equals(this.question);
        }
        
        return false;
    }
    
    @Override
    public String toString() {
        return this.question + "\n"
            + this.answer == null ? "-" : this.answer;
    }
}
