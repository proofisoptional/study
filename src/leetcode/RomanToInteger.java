package leetcode;

public class RomanToInteger {
    public static int romanToInt(String s) {
        int res = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == 'I'){
                if(i==s.length()-1){
                    res = res + 1;
                    continue;
                }
                if(s.charAt(i+1) == 'V'){
                    res = res + 4;
                    i++;
                    continue;
                } else if(s.charAt(i+1) == 'X'){
                    res = res + 9;
                    i++;
                    continue;
                } else {
                    res = res + 1;
                    continue;
                }
            } else if(s.charAt(i) == 'V'){
                res = res + 5;
            } else if(s.charAt(i) == 'X'){
                if(i==s.length()-1){
                    res = res + 10;
                    continue;
                }
                if(s.charAt(i+1) == 'L'){
                    res = res + 40;
                    i++;
                    continue;
                } else if(s.charAt(i+1) == 'C'){
                    res = res + 90;
                    i++;
                    continue;
                } else {
                    res = res + 10;
                    continue;
                }
            } else if(s.charAt(i) == 'L'){
                res = res + 50;
                continue;

            } else if(s.charAt(i) == 'C'){
                if(i==s.length()-1){
                    res = res + 100;
                    continue;
                }
                if(s.charAt(i+1) == 'D'){
                    res = res + 400;
                    i++;
                    continue;
                } else if(s.charAt(i+1) == 'M'){
                    res = res + 900;
                    i++;
                    continue;
                } else {
                    res = res + 100;
                    continue;
                }

            } else if(s.charAt(i) == 'D'){
                res = res + 500;
                continue;
            } else if(s.charAt(i) == 'M'){
                res = res + 1000;
                continue;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

}
