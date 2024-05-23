package leetcode;

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        int start = 0;
        int end = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)!=' '){
                start = i;
                while(i<s.length() && s.charAt(i)!=' '){
                    i++;
                }
                end = i;
            }
        }
        return end - start;
    }

    public static int lengthofLastWord2(String s){
        String[] words = s.split(" ");
        return words[words.length-1].length();
    }

    public static void main(String[] args) {
        System.out.println(lengthofLastWord2("   fly me   to   the moon  "));
    }
}
