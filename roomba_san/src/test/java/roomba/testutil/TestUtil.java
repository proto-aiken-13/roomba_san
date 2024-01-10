package roomba.testutil;

import java.util.List;

public class TestUtil {
    /**
     * Returns a question and answer in a format similar to a Trivia class.
     * @param question Question
     * @param answer Answer
     * @return The Question and Answer pair, as if shown in a Trivia::toString() method.
     */
    public static String triviaFormat(String question, String answer) {
        return question + "\n" +
                answer;
    }

    public static String triviaListFormat(List<String> trivia) {
        String returnMessage = "";

        for (String item : trivia) {
            returnMessage += "- " + item + "\n";
        }

        return returnMessage;
    }
}
