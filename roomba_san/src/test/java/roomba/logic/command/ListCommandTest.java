package roomba.logic.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javassist.tools.rmi.Sample;
import org.junit.Test;
import roomba.logic.commands.CommandResult;
import roomba.logic.commands.ListCommand;
import roomba.logic.commands.exceptions.CommandException;
import roomba.model.Model;
import roomba.model.Trivia;
import roomba.model.TriviaList;
import roomba.testutil.SampleTrivia;

import java.util.List;

public class ListCommandTest {

    @Test
    public void listCommandSuccess() throws CommandException {
        ListCommand listCommand = new ListCommand();
        InternalModel model = new InternalModel();
        CommandResult commandResult = listCommand.execute(model);
        assertTrue(commandResult.getFeedbackToUser().startsWith(ListCommand.SUCCESS_MESSAGE));
    }
    
    private class InternalModel implements Model {
        private final TriviaList triviaList = new TriviaList();

        public InternalModel() {
            for (Trivia trivia : SampleTrivia.sampleTrivia) {
                triviaList.addTrivia(trivia);
            }
        }

        /**
         * Adds the given trivia. Does Nothing.
         * @param trivia The trivia to add.
         */
        @Override
        public void addTrivia(Trivia trivia) {
        }

        /**
         * Deletes Trivia. Does nothing.
         * @param trivia The trivia to add.
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
            return triviaList.getAllTrivia();
        }

        /**
         * Checks if the trivia is in the list. Does nothing.
         * @param trivia
         * @return
         */
        @Override
        public boolean isInTriviaList(Trivia trivia) {
            return false;
        }
    }
}
