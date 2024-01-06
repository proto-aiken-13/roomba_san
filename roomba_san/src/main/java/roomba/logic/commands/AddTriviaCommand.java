package roomba.logic.commands;

import roomba.logic.commands.exceptions.CommandException;
import roomba.model.Model;
import roomba.model.Trivia;

public class AddTriviaCommand extends Command {
    private final Trivia triviaToAdd;

    public static final String COMMAND_WORD = "!addTrivia";

    public static final String MESSAGE_USAGE = "!addTrivia <QUESTION> a/<ANSWER>";

    public static final String DUPLICATE_MESSAGE = "uhh, it's already in the list";

    public static final String SUCCESS_MESSAGE = "woahh, didnt know that!";

    /**
     * Constructs an instance of AddTriviaCommand
     * @param question The question of trivia
     * @param answer The answer of the trivia
     */
    public AddTriviaCommand(String question, String answer) {
        triviaToAdd = new Trivia(question, answer);
    }

    /**
     * Updates the TriviaList in the Telegram Bot model with the new Trivia added
     * @param model The Telegram Bot with the trivialist.
     * @return The Command result notifying the user that the trivia has been successfully added
     * @throws CommandException A command exception in the case that the trivia has already been added.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        if (model.isInTriviaList(triviaToAdd)) {
            throw new CommandException(DUPLICATE_MESSAGE);  
        }

        model.addTrivia(triviaToAdd);
        return new CommandResult(String.format(SUCCESS_MESSAGE));
    }

    /**
     * Checks if an object is equal to this instance of AddTriviaCommand
     * @param other The object to check
     * @return Whether this object is equals to that class.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AddTriviaCommand)) {
            return false;
        }

        AddTriviaCommand otherAddTriviaCommand = (AddTriviaCommand) other;
        return this.triviaToAdd.equals(otherAddTriviaCommand.triviaToAdd);
    }
}
