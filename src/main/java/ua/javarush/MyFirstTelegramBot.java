package ua.javarush;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static ua.javarush.TelegramBotContent.*;
import static ua.javarush.TelegramBotUtils.*;

public class MyFirstTelegramBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {

        return "java_rash_test_bot";
    }

    @Override
    public String getBotToken() {

        return "6669082298:AAF-K9f-e5jtOIU2tbHb7auzOLv27-fXqkI";
    }

    @Override
    public void onUpdateReceived(Update update) {
        // TODO: основний функціонал бота будемо писати тут
        Long chatId = getChatId(update);
        if (update.hasMessage() && update.getMessage().getText().equals("/start")) {
            SendMessage message = createMessage(chatId,"*Привіт* _Лукавиця_ 19");
            sendApiMethodAsync(message);
        }
        if (update.hasMessage() && update.getMessage().getText().contains("привіт")) {
            SendMessage message = createMessage(chatId,"Як тебе звати?");
            sendApiMethodAsync(message);
        }

    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}