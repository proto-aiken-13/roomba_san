package roomba.logic;

import roomba.logic.commands.AddTriviaCommand;
import roomba.logic.commands.Command;
import roomba.logic.commands.CommandResult;
import roomba.logic.commands.exceptions.CommandException;
import roomba.logic.parser.AddTriviaParser;
import roomba.logic.parser.RoombaParser;
import roomba.logic.parser.exceptions.ParseException;
import roomba.model.Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static roomba.Ui.Message.MESSAGE_INVALID_COMMAND_FORMAT;
import static roomba.Ui.Message.MESSAGE_UNKNOWN_COMMAND;

public class LogicManager {

    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");
    private final Model model;

    private final RoombaParser roombaParser;

    public LogicManager(Model model) {
        this.model = model;
        roombaParser = new RoombaParser();
    }

    public CommandResult execute(String commandText) throws CommandException, ParseException {
        CommandResult commandResult;
        Command command = roombaParser.parseCommand(commandText);
        commandResult = command.execute(model);

        return commandResult;
    }
    
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
