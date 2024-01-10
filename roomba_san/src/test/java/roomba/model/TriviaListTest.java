package roomba.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TriviaListTest {
    
    @Test
    public void triviaListAdd_success() {
        TriviaList triviaList = new TriviaList();
        String question1 = "question";
        String answer1 = "answer";
        Trivia trivia = new Trivia(question1, answer1);  
        triviaList.addTrivia(trivia);
        assertTrue(triviaList.isInTrivia(trivia));
        assertTrue(triviaList.isInTrivia(new Trivia(question1, answer1)));
    }
}
