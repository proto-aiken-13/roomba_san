package roomba.logic.commands;

import roomba.logic.commands.exceptions.CommandException;
import roomba.model.Model;
import roomba.model.Trivia;

public class EditTriviaCommand extends Command {
    private final Trivia triviaToEdit;

    public static final String COMMAND_WORD = "!editTrivia";

    public static final String MESSAGE_USAGE = "!editTrivia <QUESTION> a/<ANSWER>";

    public static final String NOT_KNOWN_MESSAGE = "uhh, idk about that??? " +
            "might wanna consider just telling me new trivia";

    public static final String SUCCESS_MESSAGE = "yippee i love keeping up to date with things!";

    /**
     * Constructs an instance of EditTriviaCommand
     * @param question The question of trivia to edit
     * @param answer The amended answer of the trivia
     */
    public EditTriviaCommand(String question, String answer) {
        triviaToEdit = new Trivia(question, answer);
    }

    /**
     * Updates the TriviaList in the Telegram Bot model with the new Trivia added
     * @param model The Telegram Bot with the trivialist.
     * @return The Command result notifying the user that the trivia has been successfully added
     * @throws CommandException A command exception in the case that the trivia has already been added.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        if (!model.isInTriviaList(triviaToEdit)) {
            throw new CommandException(NOT_KNOWN_MESSAGE);
        }

        model.editTrivia(triviaToEdit);
        String triviaInfo = triviaToEdit.toString();
        return new CommandResult(String.format(SUCCESS_MESSAGE) + "\n" +
                triviaInfo);
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
        if (!(other instanceof EditTriviaCommand)) {
            return false;
        }

        EditTriviaCommand otherAddTriviaCommand = (EditTriviaCommand) other;
        return this.triviaToEdit.equals(otherAddTriviaCommand.triviaToEdit);
    }
}
