package leetcode;

public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int[][] table  = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0; i<=word1.length(); i++){
            for(int j = 0; j<=word2.length(); j++){
                if(i==0){
                    table[i][j] = j;
                    continue;
                }
                if(j==0){
                    table[i][j] = i;
                    continue;
                }
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    table[i][j] = table[i-1][j-1];
                } else {
                    table[i][j] = 1 + Math.min(Math.min(table[i-1][j], table[i][j-1]), table[i-1][j-1]);
                }
            }
        }
        return table[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("intention", "execution"));
    }
}
