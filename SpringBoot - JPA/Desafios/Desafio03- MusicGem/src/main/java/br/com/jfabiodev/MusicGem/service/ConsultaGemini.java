package br.com.jfabiodev.MusicGem.service;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import io.github.cdimascio.dotenv.Dotenv;

public class ConsultaGemini {

    public static String obterInformacoes(String artista) {

        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("GEMINI_API_KEY");

        ChatLanguageModel gemini = GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-1.5-flash")
                .build();

        String response = gemini.generate("Me fale informações sobre esse artista: " + artista);
        return response;
    }
}