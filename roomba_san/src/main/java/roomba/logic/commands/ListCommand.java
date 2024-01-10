package roomba.logic.commands;

import roomba.logic.commands.exceptions.CommandException;
import roomba.model.Model;

import java.util.List;

/**
 * Shows the List of all Trivia recorded by Roomba-San.
 */
public class ListCommand extends Command{
    public static final String COMMAND_WORD = "!list";

    public static final String SUCCESS_MESSAGE = "here's the things you asked me to learn:\n";

    /**
     * Returns the list of trivia
     * @param model The Telegram Bot with the trivialist.
     * @return The Command result showing the list of all trivia.
     * @throws CommandException 
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        String returnMessage = "";
        returnMessage += SUCCESS_MESSAGE;
        List<String> trivia = model.getTriviaList();

        for (String item : trivia) {
            returnMessage += item + "\n\n";
        }

        return new CommandResult(String.format(returnMessage));
    }

    /**
     * Checks if an object is equal to this instance of ListCommand
     * @param other The object to check
     * @return Whether this object is equals to that class.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (other instanceof ListCommand) {
            return true;
        }

        return false;
    }
}
