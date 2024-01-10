package roomba.model;

import java.util.List;

public class Roomba implements Model {
    
    private final TriviaList trivia;

    {
        trivia = new TriviaList();
    }
    
    @Override
    /**
     * Adds the given trivia.
     * @param trivia The trivia to add.
     */
    public void addTrivia(Trivia singleTrivia) {
        trivia.addTrivia(singleTrivia);
    }

    @Override
    /**
     * Adds the given trivia.
     * @param trivia The trivia to add.
     */
    public void deleteTrivia(Trivia singleTrivia) {
        trivia.removeTrivia(singleTrivia);
    }

    @Override
    /**
     * Returns the trivia list.
     * @return The trivia list containing all trivia.
     */
    public List<String> getTriviaList() {
        return trivia.getAllTrivia();
    }
    
    @Override
    public boolean isInTriviaList(Trivia singleTrivia) {
        return trivia.isInTrivia(singleTrivia);
    }
}
