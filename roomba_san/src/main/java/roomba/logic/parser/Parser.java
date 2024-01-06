package roomba.logic.parser;

import roomba.logic.commands.Command;
import roomba.logic.parser.exceptions.ParseException;

public interface Parser<T extends Command> {
    T parse(String userInput) throws ParseException;
}
