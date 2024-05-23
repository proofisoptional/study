package leetcode;

import java.util.*;

public class GenerateParenthesis {

    public static List<String> parenthesisHelper(int n1, int n2){
        List<String> res1 = generateParenthesis(n1);
        List<String> res2 = generateParenthesis(n2);
        Set<String> result = new HashSet<>();
        for(String s1: res1){
            for(String s2: res2){
                result.add(new StringBuilder(s1).append(s2).toString());
                if(n1 == 1){
                    result.add(new StringBuilder("(").append(s2).append(")").toString());
                }
            }
        }
        List<String> resultString = new ArrayList<>(result);
        return resultString;
    }
    public static List<String> generateParenthesis(int n) {
        Set<String> res = new HashSet<>();
        if(n==1){
            return List.of("()");
        }
        for(int i = 1; i<n; i++){
            List<String> temp = parenthesisHelper(i, n-i);
            res.addAll(temp);
        }
        List<String> result = new ArrayList<>(res);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        List<String> par = generateParenthesis(n);
        for(String s: par){
            System.out.println(s);
        }
    }

    }
/*
["","","((()))()","(()(()))","()()(())","()(())()","((())())","","(())()()","","()(()())","(()())()","",""]
["","","((())())","((()))()","(()(()))","","(()())()","--->(())(())<---","(())()()","","()(()())","","()()(())",""]

 */