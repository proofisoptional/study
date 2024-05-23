package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {

        if(s == null || s.length() < t.length() || s.length() == 0){
            return "";
        }
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c : t.toCharArray()){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        int left = 0;
        int minLeft = 0;
        int minLen = s.length()+1;
        int count = 0;
        for(int right = 0; right < s.length(); right++){
            if(map.containsKey(s.charAt(right))){
                map.put(s.charAt(right),map.get(s.charAt(right))-1);
                if(map.get(s.charAt(right)) >= 0){
                    count ++;
                }
                while(count == t.length()){
                    if(right-left+1 < minLen){
                        minLeft = left;
                        minLen = right-left+1;
                    }
                    if(map.containsKey(s.charAt(left))){
                        map.put(s.charAt(left),map.get(s.charAt(left))+1);
                        if(map.get(s.charAt(left)) > 0){
                            count --;
                        }
                    }
                    left ++ ;
                }
            }
        }
        if(minLen>s.length())
        {
            return "";
        }

        return s.substring(minLeft,minLeft+minLen);



    }

//    public static int getMinLength(HashMap<Integer, Character> charsAtPosition, HashMap<Character, Integer> targetChars){
//        int windowSize = targetChars.keySet().size();
//        List<Integer> keyList = new ArrayList<>(charsAtPosition.keySet());
//        int start = keyList.get(0);
//        int end = keyList.get(keyList.size()-1);
//        int result = end - start;
//        for(int i = 0; i<keyList.size()-windowSize-1; i++){
//            HashMap<Character, Integer> map = new HashMap<>(targetChars);
//            boolean done = false;
//            for(int j = i; j<windowSize; j++){
//                Character c = charsAtPosition.get(j);
//                if(map.containsKey(c)){
//                    if(map.get(c)>0){
//                        map.replace(c, map.get(c)-1);
//                    } else {
//                        break;
//                    }
//                }
//                done = true;
//            }
//            if(done){
//                if(keyList.get(i+windowSize) - keyList.get(i) < result){
//                    start = keyList.get(i);
//                    end = keyList.get(i+windowSize);
//                }
//            }
//        }
//
//return 0;
//    }

    public static void main(String[] args) {
        System.out.println(minWindow("a", "a"));
    }
}
