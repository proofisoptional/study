package leetcode;

public class CountAndSay {
    public static String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        else {
            StringBuilder sb = new StringBuilder();
            String s = countAndSay(n-1);
            if(s.length() == 1){
                sb.append(1);
                sb.append(s.charAt(0));
                return sb.toString();
            }

            int i = 0;
            int count = 1;
            while(i<s.length()){
                if(i == s.length()-1){
                    if(s.charAt(i) == s.charAt(i-1)){
                        sb.append(count);
                        sb.append(s.charAt(i));
                    } else {
                        sb.append(1);
                        sb.append(s.charAt(i));
                    }
                }
                else if(i<s.length() - 1 && s.charAt(i) == s.charAt(i+1)){
                    count++;
                } else {
                    sb.append(count);
                    sb.append(s.charAt(i));
                    count = 1;
                }

                i++;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

}
