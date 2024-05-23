package KaspiTasks;

public class SortingLetters {
    public static boolean sortString(String s) {
        int[] weights = new int[26];
        for (int i = 0; i < 26; i++) {
            weights[i] = i + 1;
        }

        boolean isSorted = true;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if ((weights[chars[i] - 'a'] > weights[chars[i+1] - 'a'] + 2)) {
                return false;
            }
            else {
                char temp = chars[i];
                chars[i] = chars[i+1];
                chars[i+1] = temp;
            }
        }

        return isSorted;
    }

    public static void main(String[] args) {
        System.out.println(sortString("fecba"));
    }
}
