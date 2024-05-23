package leetcode;

/*https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/*/
public class StringFirstOccurences {
    public static int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 0;
                while(j < needle.length() && haystack.charAt(i+j) == needle.charAt(j)){
                    j++;
                }
                if(needle.length() == j){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issip"));
    }
}
