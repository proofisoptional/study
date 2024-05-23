package KaspiTasks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NonRepeatingCharacters {
    public static int numberOfNonRecurringСharacters(String s) {
        Map<Character, Integer> chars = new HashMap<>();
        for (char c : s.toCharArray()) {
            chars.put(c, chars.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            if (entry.getValue() == 1) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfNonRecurringСharacters("AsdadasSdsad"));
    }
}
