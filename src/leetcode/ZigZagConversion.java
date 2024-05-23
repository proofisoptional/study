package leetcode;

//https://leetcode.com/problems/zigzag-conversion/
public class ZigZagConversion {
    public static String convert(String s, int numRows){
        if(s.length()<=numRows){
            return s;
        }
        if(numRows == 1){
            return s;
        }
        String[] result = new String[numRows];
        int length = s.length();
        int step = 1;
        int iterator = 0;
        for(int i = 0; i<length; i++){
            if(result[iterator] == null){
                result[iterator] = "";
            }
            result[iterator] = result[iterator].concat(s.substring(i, i+1));
            iterator = iterator + step;
            if(iterator == -1){
                iterator = 1;
                step = 1;
            }
            if(iterator == numRows){
                iterator = numRows - 2;
                step = -1;
            }
        }

        String res = "";
        for(String resul : result){
            res = res.concat(resul);
        }
        return res;
    }
}