package leetcode;

import java.util.*;
/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number
 */
public class LetterCombinations {
    static Map<Integer, String> mapping = new HashMap<>() {{
            put(1, "");
            put(2, "abc");
            put(3, "def");
            put(4, "ghi");
            put(5, "jkl");
            put(6, "mno");
            put(7, "pqrs");
            put(8, "tuv");
            put(9, "wxyz");
    }};


    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        if(digits.length() == 1){
            if(digits.charAt(0)-48 == 1){
                res.add("");
                return res;
            }
            String str = mapping.get(digits.charAt(0)-48);
            for(int i = 0; i<str.length(); i++){
                StringBuilder sb = new StringBuilder();
                sb.append(str.charAt(i));
                res.add(sb.toString());
            }
            return res;
        }
        int num = digits.charAt(0) - 48;
        if(num == 1){
            return letterCombinations(digits.substring(1));
        }
        String str = mapping.get(num);
        for(int i = 0; i<str.length(); i++){
            List<String> temp = letterCombinations(digits.substring(1));
            for(String l : temp){
                StringBuilder sb = new StringBuilder();
                sb.append(str.charAt(i)).append(l);
                res.add(sb.toString());
            }
        }




        return res;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }
}
