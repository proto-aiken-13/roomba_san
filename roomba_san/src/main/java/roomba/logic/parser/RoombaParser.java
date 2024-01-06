package roomba.logic.parser;

import roomba.logic.commands.AddTriviaCommand;
import roomba.logic.commands.Command;
import roomba.logic.parser.exceptions.ParseException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static roomba.Ui.Message.MESSAGE_INVALID_COMMAND_FORMAT;
import static roomba.Ui.Message.MESSAGE_UNKNOWN_COMMAND;

public class RoombaParser {
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");
    private Command previousCommand = null;

    /**
     * Parses the user input to determine and retrieve the appropriate command for execution.
     * It updates the previous command statefully.
     *
     * @param userInput The full user input string.
     * @return The parsed command based on the user input.
     * @throws ParseException If the user input does not conform to the expected format.
     */
    public Command parseCommand(String userInput) throws ParseException {
        Command command;
        try {
            command = getCommand(userInput);
        } catch (ParseException e) {
            previousCommand = null;
            throw e;
        }

        previousCommand = command;

        return command;
    }

    /**
     * Parses user input to extract the command for execution.
     *
     * @param userInput The full user input string.
     * @return The appropriate command based on the user input.
     * @throws ParseException If the user input does not conform to the expected format.
     */
    public Command getCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");

        switch (commandWord) {
        case AddTriviaCommand.COMMAND_WORD:
            return new AddTriviaParser().parse(arguments);
        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }
}
