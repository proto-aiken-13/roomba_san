package roomba.commands;

/**
 * Represents a command with hidden internal logic and the ability to be executed.
 */
public abstract class Command {
    public abstract CommandResult execute();
}
