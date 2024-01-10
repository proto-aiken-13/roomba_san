package roomba.model;

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
     */
    public void addTrivia(Trivia trivia) {
        triviaItems.add(trivia);
    }

    /**
     * Removes trivia from the triviaList.
     * @param trivia The Trivia to be removed.
     * @return The removed trivia.
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
        if (triviaItems.contains(trivia)) {
            return true;
        }

        for (Trivia obj : triviaItems) {
            if (obj.equals(trivia)) {
                return true;
            }
        }

        return false;
    }
}
