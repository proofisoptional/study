package leetcode;

public class PalindromeInt {
    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        String s = String.valueOf(x);
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(s.length()-i-1) != s.charAt(i)){
                return false;
            }
        }

        return true;
    }
}
