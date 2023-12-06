package roomba.parser;

import roomba.commands.Command; 
import roomba.parser.exceptions.ParseException;

public interface Parser<T extends Command> {
    T parse(String userInput) throws ParseException;
}
