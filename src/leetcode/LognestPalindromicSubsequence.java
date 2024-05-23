package leetcode;

//https://leetcode.com/problems/longest-palindromic-substring/
public class LognestPalindromicSubsequence {
    public static String longestPalindromicSubsequence(String s){
        String result = s.substring(0, 1);
        int length = s.length();
        int maxLength = 1;
        for(int i = 0; i<length; i++){
            int pallength = 1;
            int left = i-1;
            int right = i+1;
            while(left >= 0 && s.charAt(i)==s.charAt(left)){
                left--;
                pallength++;

            }
            while(right<length && s.charAt(i) == s.charAt(right)){
                right++;
                pallength++;
            }
            while(left>=0 && right <length && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
                pallength = pallength + 2;
            }
            if(maxLength < pallength){
                maxLength = pallength;
                result = s.substring(left+1, right);
            }
        }
        return result;

    }


}
