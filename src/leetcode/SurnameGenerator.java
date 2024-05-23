package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SurnameGenerator {
    public static long factorial(int n) {
        if (n <= 2) {
            return n;
        }
        return n * factorial(n - 1);
    }
    public static Long getPositionOfSurname(String surname){
        String uniqSurname = surname.toUpperCase();
        ArrayList<Character> charArray = new ArrayList<>();
        for(int i = 0; i<surname.length(); i++){
            charArray.add(uniqSurname.charAt(i));
        }
        charArray.sort(Comparator.comparingInt(c -> c.charValue()));
        Long result = 0L;
        int index = 0;
        while(charArray.size() != 0){
            int index2 = 0;
            while(uniqSurname.charAt(index) != charArray.get(index2)){
                index2++;
            }
            result = result + factorial(uniqSurname.length() - index - 1) * (index2);
            charArray.remove(index2);
            index++;
        }



        return result + 1;
    }

    public static void main(String[] args) {
        System.out.println(getPositionOfSurname("Turing"));
    }
}
