package main.java.com.blandy.translator;

import java.util.HashMap;
import java.util.Map;

public class Translator {

    private Map<String, String> translations = new HashMap<>();

    public boolean isEmpty() {
        return translations.isEmpty();
    }

    public void addTranslation(String word, String translation) {
        if (translations.containsKey(word)) {
            translation = translate(word) + ", " + translation;
        }
        translations.put(word, translation);
    }

    public String translate(String word) {
        return translations.get(word);
    }

    public String translatePhrase(String phrase) {
        String[] words = phrase.split(" ");
        StringBuilder translatedPhrase = new StringBuilder();
        for (String word : words) {
            String translation = getFirstTranslation(word);
            translatedPhrase
                    .append(" ")
                    .append(translation);
        }
        return translatedPhrase.toString().trim();
    }

    private String getFirstTranslation(String word) {
        String translation = translate(word);
        if (translation.contains(","))
            translation = translation.substring(0, translation.indexOf(","));
        return translation;
    }

}
