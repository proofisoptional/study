//https://leetcode.com/problems/integer-to-roman/submissions/
package leetcode;

public class IntToRoman {
    public static String intToRoman(int num) {
        String ans = "";
        String s = String.valueOf(num);
        for(int i = 0; i < s.length(); i++){
            int number = (s.charAt(i) - 48);
            int power = (int)Math.pow(10, s.length() - i-1);
            if(number>0 && number<4){
                for(int j = 0; j<number; j++){
                    if(power == 1000){
                        ans = ans + "M";
                    } else if (power == 100){
                        ans = ans + "C";
                    } else if (power == 10){
                        ans = ans + "X";
                    } else if (power == 1){
                        ans = ans + "I";
                    }
                }
            } else if (number >= 4 && number <=9){
                if(number == 4){
                    if (power == 100){
                        ans = ans + "CD";
                    } else if (power == 10){
                        ans = ans + "XL";
                    } else if (power == 1){
                        ans = ans + "IV";
                    }
                } else if(number == 5){
                    if (power == 100){
                        ans = ans + "D";
                    } else if (power == 10){
                        ans = ans + "L";
                    } else if (power == 1){
                        ans = ans + "V";
                    }
                } else if(number == 6){
                    if (power == 100){
                        ans = ans + "DC";
                    } else if (power == 10){
                        ans = ans + "LX";
                    } else if (power == 1){
                        ans = ans + "VI";
                    }
                } else if(number == 7){
                    if (power == 100){
                        ans = ans + "DCC";
                    } else if (power == 10){
                        ans = ans + "LXX";
                    } else if (power == 1){
                        ans = ans + "VII";
                    }
                } else if(number == 8){
                    if (power == 100){
                        ans = ans + "DCCC";
                    } else if (power == 10){
                        ans = ans + "LXXX";
                    } else if (power == 1){
                        ans = ans + "VIII";
                    }
                } else if(number == 9){
                    if (power == 100){
                        ans = ans + "CM";
                    } else if (power == 10){
                        ans = ans + "XC";
                    } else if (power == 1){
                        ans = ans + "IX";
                    }
                }
            }


        }

        return ans;
    }
}
