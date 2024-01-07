package roomba.logic.parser;

import roomba.logic.commands.AddTriviaCommand;
import roomba.logic.parser.exceptions.ParseException;

import static roomba.Ui.Message.MESSAGE_INVALID_COMMAND_FORMAT;
import static roomba.logic.commands.AddTriviaCommand.MESSAGE_USAGE;

/**
 * Parses a trivia command string to acquire the question and answer.
 */
public class AddTriviaParser implements Parser<AddTriviaCommand> {

    /**
     * Parses a trivia command string to return an AddTriviaCommand to execute
     * @param args The trivia command string
     * @return The Add Trivia Command to execute
     * @throws ParseException The error message if the command is incorrectly formatted.
     */
    public AddTriviaCommand parse(String args) throws ParseException {
        try {
            String[] questionAndAnswer = args.split(" " + Prefix.PREFIX_ANSWER, 2);
            String question = questionAndAnswer[0];
            String answer = questionAndAnswer[1];

            return new AddTriviaCommand(question, answer);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_USAGE));
        }
    }
}
