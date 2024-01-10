package roomba.model;

import java.util.List;

public interface Model {

    /**
     * Adds the given trivia.
     * @param trivia The trivia to add.
     */
    public void addTrivia(Trivia trivia);

    /**
     * Deletes the given trivia.
     * @param trivia The trivia to delete.
     */
    public void deleteTrivia(Trivia trivia);

    /**
     * Returns the trivia list.
     * @return The trivia list containing all trivia.
     */
    public List<String> getTriviaList();

    /**
     * Checks if the trivia is stored in the model
     * @param trivia The trivia to check
     * @return Whether the trivia is in the model.
     */
    public boolean isInTriviaList(Trivia trivia);

    /**
     * Edits the given trivia.
     * @param trivia The trivia to delete.
     */
    public void editTrivia(Trivia trivia);
}
