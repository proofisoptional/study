package leetcode;

public class ValidNumber {
    public static boolean isNumber(String s) {
        boolean dotAppeared = false;
        boolean eAppeared = false;
        boolean numberAppeared = false;
        boolean isNumberAfterE = true;

        char[] c = s.toCharArray();
        for(int i = 0; i<c.length; i++){
            if(c[i] >= '0' && c[i] <= '9'){
                numberAppeared = true;
                isNumberAfterE = true;
            } else if(c[i] == '.'){
                if(eAppeared || dotAppeared){
                    return false;
                }
                dotAppeared = true;
            } else if (c[i] == 'e' || c[i] == 'E'){
                if(eAppeared || !numberAppeared){
                    return false;
                }
                isNumberAfterE = false;
                eAppeared = true;
            } else if(c[i] == '-' || c[i] == '+'){
                if(i>0 && (c[i-1] != 'e' && c[i-1]!='E')){
                    return false;
                }
            } else {
                return false;
            }
        }
        return numberAppeared && isNumberAfterE;
    }

    public static void main(String[] args) {
        String[] correctstrings = {"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
        String[] incorrectstrings = {"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"};

        for(String s : incorrectstrings){
            System.out.println(isNumber(s));
        }
    }
}
