package leetcode;


import java.util.HashMap;
import java.util.Map;

public class ScrambleString {
     Map<String, Boolean> mp = new HashMap<>();
    public  boolean isScramble(String s1, String s2) {
        int n = s1.length();

        if(s1.equals(s2)){
            return true;
        }

        if(s2.length() != s1.length()){
            return false;
        }

        String key = s1 + " " + s2;


        if(mp.containsKey(key)){
            return mp.get(key);
        }

        for(int i = 1; i<n; i++){
            boolean noSwap = (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i)));
            if(noSwap){
                mp.put(key, true);
                return true;
            }
            boolean withSwap = (isScramble(s1.substring(0, i), s2.substring(n-i))
                    && isScramble(s1.substring(i), s2.substring(0, n-i)));
            if(withSwap) {
                mp.put(key, true);
                return true;
            }
        }

        mp.put(key, false);

        return false;


    }

    public static void main(String[] args) {
//        System.out.println(isScramble("great", "rgeat"));
        ScrambleString scrambleString = new ScrambleString();
        System.out.println(scrambleString.isScramble("abcde", "caebd"));
        System.out.println(scrambleString.isScramble("great", "rgeat"));
    }
}
