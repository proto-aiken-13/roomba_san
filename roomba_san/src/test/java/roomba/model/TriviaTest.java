package roomba.model;

import org.junit.Test;
import roomba.testutil.TestUtil;

import static org.junit.Assert.assertEquals;

public class TriviaTest {
    @Test
    public void triviaEqualSuccess() {
        String question1 = "Who designed the Empire State Building?";
        String answer1 = "Shreve, Lamb & Harmon";
        assertEquals(new Trivia(question1, answer1), new Trivia(question1, answer1));
    }

    @Test
    public void triviaEqualMissingAnswerSuccess() {
        String question1 = "What is Descriptive Analysis?";
        String answer1 = "Getting an accurate description of phenomena to support a hypothesis";
        assertEquals(new Trivia(question1, answer1), new Trivia(question1));
    }

    @Test
    public void triviaToString() {
        String question1 = "What is predictive learning?";
        String answer1 = "The ability to accurately predict a course of action given a trend or descriptive analysis";
        assertEquals(new Trivia(question1, answer1).toString(), TestUtil.triviaFormat(question1, answer1));
    }
}
