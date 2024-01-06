package roomba.model;

import java.util.List;

public interface Model {

    /**
     * Adds the given trivia.
     * @param trivia The trivia to add..
     */
    public void addTrivia(Trivia trivia);

    /**
     * Adds the given trivia.
     * @param trivia The trivia to add..
     */
    public void deleteTrivia(Trivia trivia);

    /**
     * Returns the trivia list.
     * @return The trivia list containing all trivia.
     */
    public List<String> getTriviaList();
    
    public boolean isInTriviaList(Trivia trivia);
}
