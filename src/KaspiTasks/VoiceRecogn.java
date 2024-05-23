package KaspiTasks;

import java.util.*;

public class VoiceRecogn {
    public static List<String> incorrectElements(String text) {
        String[] words = text.split(" ");
        Set<String> correctWords = new HashSet<>();
        List<String> incorrectWords = new ArrayList<>();

        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            if (correctWords.contains(word)) {
                continue;
            }
            boolean isValid = false;
            for (int i = 1; i <= word.length(); i++) {
                String prefix = word.substring(0, i);
                if (correctWords.contains(prefix)) {
                    String suffix = word.substring(i);
                    if (!suffix.isEmpty() && correctWords.contains(suffix)) {
                        correctWords.add(word);
                        isValid = true;
                        break;
                    }
                }
            }
            if (!isValid) {
                incorrectWords.add(word);
            }
        }

        return incorrectWords;

    }

    public static void main(String[] args) {
        System.out.println(incorrectElements("подскажите как подскажитеоткрыть открыть депозит в вашем депозитподскажитедепозит банке"));
    }
}
