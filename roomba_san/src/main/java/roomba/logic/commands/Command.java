package roomba.logic.commands;

import roomba.logic.commands.exceptions.CommandException;
import roomba.model.Model;

/**
 * Represents a command with hidden internal logic and the ability to be executed.
 */
public abstract class Command {
    public abstract CommandResult execute(Model model) throws CommandException;
}
