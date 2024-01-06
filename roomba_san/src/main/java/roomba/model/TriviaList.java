package roomba.model;

import roomba.model.exceptions.TriviaListException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Auxiliary class to contain all Trivia questions.
 */
public class TriviaList {
    private HashSet<Trivia> triviaItems = new HashSet<>();

    /**
     * Adds trivia to the trivialist.
     * @param trivia The trivia to be added.
     * @throws TriviaListException Error message if the Trivia is already in the list.
     */
    public void addTrivia(Trivia trivia) {
        triviaItems.add(trivia);
    }

    /**
     * Removes trivia from the triviaList.
     * @param trivia The Trivia to be removed.
     * @return The removed trivia.
     * @throws TriviaListException Error message if no such trivia exists in the triviaList.
     */
    public Trivia removeTrivia(Trivia trivia) {
        Trivia triviaReturn = null;
        for (Trivia obj : triviaItems) {
            if (obj.equals(trivia)) {
                triviaReturn = obj;
                triviaItems.remove(obj);
            }
        }
        return triviaReturn;
    }

    /**
     * Retrieves trivia from the triviaList.
     * @param trivia The Trivia to be retrieved
     * @return The requested Trivia.
     * @throws TriviaListException Error message if no such trivia exists in the triviaList.
     */
    public Trivia getTrivia(Trivia trivia) {
        Trivia triviaReturn = null;
        for (Trivia obj : triviaItems) {
            if (obj.equals(trivia)) {
                triviaReturn = obj;
            }
        }
        return triviaReturn;
    }

    /**
     * Shows the list of all Trivia.
     * @return The list of all Trivia.
     */
    public List<String> getAllTrivia() {
        List<String> returnList = new ArrayList<>();
    
        for (Trivia trivia : triviaItems) {
            returnList.add(trivia.toString());
        }
    
        return returnList;
    }

    /**
     * Checks if a particular trivia is within the trivia list.
     * @param trivia The trivia to be checked.
     * @return If the trivia is in the list.
     */
    public boolean isInTrivia(Trivia trivia) {
        return triviaItems.contains(trivia);
    }
}
