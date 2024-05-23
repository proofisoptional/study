//https://leetcode.com/problems/string-to-integer-atoi/
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class StringToInt {
    public static int myAtoi(String s) {
        if(s.length() == 0){
            return 0;
        }
        List<Integer> result = new ArrayList<>();
        boolean isNegative = false;
        int index = 0;
        int i = 0;
        int answer = 0;
        while(i<s.length() && s.charAt(i) == ' '){
            i++;
        }
        if(i<s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')){
            if (s.charAt(i) == '-'){
                isNegative = true;
            }
            i++;
        }
        while( i<s.length() && s.charAt(i) <= 59 && s.charAt(i) >= 48){
            result.add(s.charAt(i) - 48);
            i++;
        }

        if(result.isEmpty()){
            return 0;
        }

        if(result.size() >= 10){
            if(result.get(0)>2){
                if(isNegative){
                    return -2147483648;
                } else {
                    return 2147483647;
                }
            }
        }

        for(int j = 0; j < result.size(); j++){
            answer = answer + result.get(j) * (int)Math.pow(10, result.size()-j-1);
            if(answer < 0){
                if(isNegative){
                    return -2147483648;
                } else {
                    return 2147483647;
                }
            }
        }
        if(isNegative){
            answer = answer * (-1);
        }
        return answer;
    }

}
