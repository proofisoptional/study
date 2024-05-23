package YandexContest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Skobochki {
    static int n = 0;

    public static void skobochki(StringBuilder sb, int open, int close){

        if(sb.length() == n*2){
            System.out.println(sb.toString());
            return;
        }

        if(open < n)
            skobochki(new StringBuilder(sb).append("("), open+1, close);
        if(close < open)
            skobochki(new StringBuilder(sb).append(")"), open, close+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        skobochki(sb, 0, 0);
    }
}
