package leetcode;

public class Palindrome {
    public static boolean isPalindrome(String input){
        int start = 0;
        int end = input.length() - 1;
        while(start<end){
            int startChar = input.charAt(start);
            int endChar = input.charAt(end);
            if(startChar == endChar || Math.abs(startChar - endChar) == 32){
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeIgnoreSymbols(String input){
        int start = 0;
        int end = input.length() - 1;
        while(start<end){
            while(start < end && input.charAt(start)<65 || input.charAt(start)>122 || (input.charAt(start)>90 && input.charAt(start)<97)){
                start++;
            }
            while(start < end && input.charAt(end)<65 || input.charAt(end)>122 || (input.charAt(end)>90 && input.charAt(end)<97)){
                end--;
            }
            int startChar = input.charAt(start);
            int endChar = input.charAt(end);
            if(startChar == endChar || Math.abs(startChar - endChar) == 32){
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindromeIgnoreSymbols("'Mad'''am@"));
    }
}
