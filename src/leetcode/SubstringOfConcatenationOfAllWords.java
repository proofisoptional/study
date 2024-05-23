package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SubstringOfConcatenationOfAllWords {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int lengthOfWords = words.length * words[0].length();
        char[] charArray = s.toCharArray();
        int counter = 0;
        int i = 0;
        List<String> matchingWords = new ArrayList<>();
        List<String> leftToMatch = Arrays.stream(words).toList();
        while(i<charArray.length){
            char c = charArray[i];
            if(counter==0 || counter%words[0].length()==0){
                System.out.println("debug 0");

                Iterator<String> iter = leftToMatch.iterator();
                for(int j = 0; j<leftToMatch.size(); j++){
                    String w = leftToMatch.get(j);
                    if(w.charAt(0) == c){
                        matchingWords.add(w);
                        leftToMatch.remove(j);
                    }
                    if(!matchingWords.isEmpty()){
                        counter++;
                    } else {
                        counter = 0;
                    }
                }
//                for(String w: leftToMatch){
//                    if(w.charAt(0) == c){
//                        matchingWords.add(w);
//                        leftToMatch.remove(w);
//                    }
//                    if(!matchingWords.isEmpty()){
//                        counter++;
//                    } else {
//                        counter = 0;
//                    }
//                }
            } else {
                System.out.println("debug 1");
                int index = counter%words[0].length();
                for(int j = 0; j<matchingWords.size(); j++){
                    String w = matchingWords.get(j);
                    if(w.charAt(index) == c){
                        if(index == w.length()-1){
                            matchingWords.remove(j);
                            break;
                        }
                    }
                }
                for(String w: matchingWords){
                    if(w.charAt(index) == c){
                        if(index == w.length()-1){
                            matchingWords.remove(w);
                            break;
                        }
                    } else {
                        leftToMatch.add(w);
                    }
                }
            }
            if(counter == lengthOfWords && leftToMatch.isEmpty()){
                result.add(i - lengthOfWords);
            }
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"foo","bar"};
        System.out.println(findSubstring("barfoothefoobarman", words));
    }
}
