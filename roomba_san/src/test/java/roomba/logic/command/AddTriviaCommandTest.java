package roomba.logic.command;

import static org.junit.Assert.assertEquals;
import static roomba.testutil.Assert.assertThrows;

import org.junit.Test;
import roomba.logic.commands.AddTriviaCommand;
import roomba.logic.commands.CommandResult;
import roomba.logic.commands.exceptions.CommandException;
import roomba.model.Model;
import roomba.model.Trivia;
import roomba.model.TriviaList;
import roomba.testutil.TestUtil;

import java.util.ArrayList;
import java.util.List;

public class AddTriviaCommandTest {
    @Test
    public void addTrivia_success() throws CommandException {
        String question1 = "Who invented the Lightbulb?";
        String answer1 = "Probably Nikola Tesla or some Canadian guy lmao";
        AddTriviaCommand addCommand1 = new AddTriviaCommand(question1, answer1);
        InternalModel internalModel = new InternalModel();
        
        
        CommandResult commandResult = addCommand1.execute(internalModel);
        assertEquals(String.format(AddTriviaCommand.SUCCESS_MESSAGE + "\n" +
                        TestUtil.triviaFormat(question1, answer1)), commandResult.getFeedbackToUser());
    }

    @Test
    public void addTrivia_failure() throws CommandException {
        String question1 = "What does react mean?";
        String answer1 = "React means an immediate response to a given stimuli or situation";
        String answer2 = "React is a JavaScript framework";

        InternalModel internalModel = new InternalModel();
        AddTriviaCommand addTrivia1 = new AddTriviaCommand(question1, answer1);
        AddTriviaCommand addTrivia2 = new AddTriviaCommand(question1, answer1);
        AddTriviaCommand addTrivia3 = new AddTriviaCommand(question1, answer2);

        addTrivia1.execute(internalModel);

        assertThrows(CommandException.class, AddTriviaCommand.DUPLICATE_MESSAGE, () -> addTrivia2.execute(internalModel));
        assertThrows(CommandException.class, AddTriviaCommand.DUPLICATE_MESSAGE, () -> addTrivia3.execute(internalModel));
    }

    private class InternalModel implements Model {
        private final TriviaList triviaList = new TriviaList();

        /**
         * Adds the given trivia.
         * @param trivia The trivia to add..
         */
        @Override
        public void addTrivia(Trivia trivia) {
            triviaList.addTrivia(trivia);
        }

        /**
         * Deletes Trivia. Does nothing.
         * @param trivia The trivia to add..
         */
        @Override
        public void deleteTrivia(Trivia trivia) {
        }

        /**
         * Returns an empty List.
         * @return An empty List.
         */
        @Override
        public List<String> getTriviaList() {
            return new ArrayList<>();
        }

        /**
         * Checks if the trivia is in the list.
         * @param trivia
         * @return
         */
        @Override
        public boolean isInTriviaList(Trivia trivia) {
            return triviaList.isInTrivia(trivia);
        }
    }
}
