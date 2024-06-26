package leetcode;

//https://leetcode.com/problems/wildcard-matching/
public class WildcardMatching {
    public static boolean isMatch(String s, String p) {
        boolean T[][] = new boolean[s.length()+1][p.length()+1];

        T[0][0] = true;
        for(int i = 1; i<T[0].length; i++){
            if(p.charAt(i-1) == '*'){
                T[0][i-1] = true;
            }
        }




        for(int i = 1; i<T.length; i++){
            for(int j = 1; j<T[0].length; j++){
                if(s.charAt(i-1) == p.charAt(j-1)){
                    T[i][j] = T[i-1][j-1];
                } else if (p.charAt(j-1) == '?'){
                    T[i][j] = T[i-1][j-1];
                } else if (p.charAt(j-1) == '*'){
                    T[i][j] = T[i-1][j];
                }
            }
        }

        return T[s.length()][p.length()];

    }

    public static void main(String[] args) {
        System.out.println(isMatch("aab", "*a*b"));
    }

}
