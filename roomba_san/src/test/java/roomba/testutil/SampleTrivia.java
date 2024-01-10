package roomba.testutil;

import roomba.model.Trivia;
import roomba.model.TriviaList;

import java.util.ArrayList;
import java.util.List;

public class SampleTrivia {
    public static Trivia[] sampleTrivia = { new Trivia("What is the Capital of Australia?", "Melbourne"),
            new Trivia("What is the chemical symbol for gold?", "Au"),
            new Trivia("Who was the first President of the United States?", "George Washington"),
            new Trivia("Who played the lead role in the movie Forrest Gump?", "Tom Hanks"),
            new Trivia("Name the longest river in the world.", "Amazon River")
    };

    public static String[] sampleTriviaStrings = {
            "- What is the Capital of Australia?\n" +
            "   Melbourne",
            "- What is the chemical symbol for gold?\n" +
            "   Au",
            "- Who was the first President of the United States?\n" +
            "   George Washington",
            "- Who played the lead role in the movie Forrest Gump?\n" +
            "   Tom Hanks",
            "- Name the longest river in the world.\n" +
            "   Amazon river"
    };
}
