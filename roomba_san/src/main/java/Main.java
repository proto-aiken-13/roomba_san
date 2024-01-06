
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import roomba.bot.RoombaBot;

/**
 * The main class used to run the bot.
 */
public class Main {

    /**
     * The main class used to execute the bot.
     * @param args The message string.
     */
    public static void main(String args[]) {
        // Register our bot
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new RoombaBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
