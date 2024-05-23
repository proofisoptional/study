package YandexContest;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JewAndStones {
    public static int numbOfStones(String J, String S){
        Set<Character> set = new HashSet<>();
        int res = 0;
        for(int i = 0; i<J.length(); i++){
            set.add(J.charAt(i));
        }
        for(int i = 0; i<S.length(); i++){
            if(set.contains(S.charAt(i))){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String J = scanner.nextLine();
        String S = scanner.nextLine();
        System.out.println(numbOfStones(J, S));
    }
}
