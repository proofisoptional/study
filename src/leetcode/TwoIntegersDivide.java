package leetcode;

public class TwoIntegersDivide {

    public static int divide(int dividend, int divisor) {

        if(divisor == 1 || divisor == -1){
            if(dividend == -2147483648){
                if(divisor == 1){
                    return dividend;
                } else {
                    return 2147483647;
                }
            }
        }

        if(Math.abs(dividend) < Math.abs(divisor)){
            return 0;
        }

        if(dividend == divisor){
            return 1;
        }



        boolean isDivisorNegative = false;

        if(divisor<0){
            isDivisorNegative = true;
            divisor = -divisor;
        }

        String dividendBit = Integer.toBinaryString(dividend);
        String divisorBit = Integer.toBinaryString(divisor);
        StringBuilder quotient = new StringBuilder();


        StringBuilder dividendPart = new StringBuilder(dividendBit.substring(0, divisorBit.length()));
        int index = divisorBit.length();


        while(index<=dividendBit.length()){
            if(Integer.parseInt(dividendPart.toString(), 2) >= divisor){
                quotient.append("1");
                if(index == dividendBit.length()){
                    break;
                }
                int res = Integer.parseInt(dividendPart.toString(), 2) - divisor;
                if(res != 0){
                    dividendPart = new StringBuilder(Integer.toBinaryString(res)).append(dividendBit.charAt(index));
                } else {
                    dividendPart = new StringBuilder().append(dividendBit.charAt(index));
                }
                index++;
            } else {
                quotient.append("0");
                if(index == dividendBit.length()){
                    break;
                }
                dividendPart = dividendPart.append(dividendBit.charAt(index));
                index++;
            }
        }

        System.out.println(quotient.toString());
        Integer result = Integer.parseUnsignedInt(quotient.toString(), 2);
        if(isDivisorNegative){
            result = result * (-1);
        }
        return result;
    }

    public static void main(String[] args) {
        //System.out.println(divide(-2147483648, 2));
        System.out.println(divide(458, 15));
    }
}
