package roomba.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class TriviaListTest {
    
    @Test
    public void triviaListAdd() {
        TriviaList triviaList = new TriviaList();
        String question1 = "question";
        String answer1 = "answer";
        Trivia trivia = new Trivia(question1, answer1);  
        triviaList.addTrivia(trivia);
        assertTrue(triviaList.isInTrivia(trivia));
        assertTrue(triviaList.isInTrivia(new Trivia(question1, answer1)));
    }

    @Test
    public void triviaListEdit() {
        TriviaList triviaList = new TriviaList();
        String question1 = "question";
        String answer1 = "answer";
        String answer2 = "answer2";
        Trivia trivia = new Trivia(question1, answer1);
        Trivia triviaNew = new Trivia(question1, answer2);
        triviaList.addTrivia(trivia);
        triviaList.editTrivia(triviaNew);
        assertTrue(triviaList.isInTrivia(triviaNew));
        assertEquals(triviaList.getTrivia(triviaNew).getAnswer(), answer2);
        assertNotEquals(triviaList.getTrivia(triviaNew).getAnswer(), answer1);
    }
}
