
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Represents the main bot where all bot operations take place.
 */
public class Roomba extends TelegramLongPollingBot {
    
    private final String BOT_ID = "roomba_san_bot";
    
    private final String BOT_TOKEN = "6337550947:AAEUmxp2OkraBvye539SLlSaRjjf1lbjXnI";

    /**
     * Replies to an update message with the message itself.
     * @param update The update, presumably containing the message.
     */
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(update.getMessage().getChatId().toString());
            message.setText(update.getMessage().getText());

            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Retrieves the bot's Telegram username.
     * @return The bot ID.
     */
    @Override
    public String getBotUsername() {
        return BOT_ID;
    }

    /**
     * Retrieves the bot's Telegram token/
     * @return The bot token/
     */
    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }
}
