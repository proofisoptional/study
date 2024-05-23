package leetcode;

public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int maxlength = a.length() > b.length() ? a.length() : b.length();
        int minlength = a.length() > b.length() ? b.length() : a.length();

        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        String longestString = a.length() > b.length() ? a : b;
        boolean addval = false;
        int j = 0;
        while(j<maxlength){
            if(j>minlength - 1){
                if(addval){
                    if(longestString.charAt(j) == '1'){
                        res.append('0');
                    } else if(longestString.charAt(j) == '0') {
                        res.append('1');
                        addval = false;
                    }
                } else {
                    res.append(longestString.charAt(j));
                }
                j++;
                continue;
            }
            if(a.charAt(j) == '1' && b.charAt(j) == '1'){
                if(addval){
                    res.append('1');
                } else {
                    res.append('0');
                }
                addval = true;
            } else if(a.charAt(j) == '1' || b.charAt(j) == '1'){
                if(addval){
                    res.append('0');
                } else {
                    res.append('1');
                }
            } else {
                if(addval){
                    res.append('1');
                } else {
                    res.append('0');
                }
                addval = false;
            }
            j++;
        }

        if(addval){
            res.append('1');
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("100", "110010"));
    }
}
