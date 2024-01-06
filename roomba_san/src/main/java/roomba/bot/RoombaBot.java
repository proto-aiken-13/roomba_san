package roomba.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import roomba.logic.commands.exceptions.CommandException;
import roomba.logic.parser.RoombaParser;
import roomba.logic.parser.exceptions.ParseException;
import roomba.model.Roomba;

/**
 * Represents the main bot where all bot operations take place.
 */
public class RoombaBot extends TelegramLongPollingBot {
    
    private final String BOT_ID = "roomba_san_bot";
    
    private final String BOT_TOKEN = "6337550947:AAEUmxp2OkraBvye539SLlSaRjjf1lbjXnI";

    private final RoombaParser messageParser = new RoombaParser();

    private final Roomba roomba = new Roomba();

    /**
     * Replies to an update message with the message itself.
     * @param update The update, presumably containing the message.
     */
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
            message.setChatId(update.getMessage().getChatId().toString());

            try {
                message.setText(messageParser.parseCommand(update.getMessage().getText()).execute(roomba).toString());
                execute(message); // Call method to send the message
            } catch (ParseException | CommandException e) {
                message.setText(e.getMessage());
                try {
                    execute(message);
                } catch (TelegramApiException t) {
                    t.printStackTrace();
                }
            } catch (TelegramApiException c) {
                c.printStackTrace();
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
