package roomba.logic.parser;

import org.junit.Test;
import roomba.logic.commands.AddTriviaCommand;
import roomba.logic.parser.exceptions.ParseException;

import static roomba.Ui.Message.MESSAGE_INVALID_COMMAND_FORMAT;
import static roomba.logic.commands.AddTriviaCommand.MESSAGE_USAGE;
import static roomba.logic.parser.CommandParserTestUtil.assertParseFailure;
import static roomba.logic.parser.CommandParserTestUtil.assertParseSuccess;

public class AddTriviaParserTest {
    private AddTriviaParser parser = new AddTriviaParser();
    
    @Test
    public void parse_allFieldsPresent_success() throws ParseException {
        String userInput = "question a/answer";
        assertParseSuccess(parser, userInput, new AddTriviaCommand("question", "answer"));

        String userInput2 = "Who killed Abraham Lincoln? a/John Wilkes Booth";
        assertParseSuccess(parser, userInput2, new AddTriviaCommand("Who killed Abraham Lincoln?",
                "John Wilkes Booth"));
    }
    
    @Test
    public void parse_fieldsAbsent_failure() throws ParseException {
        String userInput = "question";
        assertParseFailure(parser, userInput, String.format(MESSAGE_INVALID_COMMAND_FORMAT, MESSAGE_USAGE));
    }
}
