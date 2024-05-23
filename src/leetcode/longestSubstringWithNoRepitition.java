package leetcode;

import java.util.ArrayList;

public class longestSubstringWithNoRepitition {
    public static int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()){
            return 0;
        }
        int res = 1;
        for(int i = 0; i<s.length()-1; i++){
            ArrayList<Character> characters = new ArrayList<>();
            int temp = 0;
            int index = i;
            while(i<s.length() && !characters.contains(s.charAt(i))){
                temp++;
                characters.add(s.charAt(i));
                i++;
            }
            i = index;
            if(res < temp){
                res = temp;
            }
            if(res >= s.length() - i+1){
                break;
            };
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int j = lengthOfLongestSubstring(s);
        System.out.println(j);
    }
}
