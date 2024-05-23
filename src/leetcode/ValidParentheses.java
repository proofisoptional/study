package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Integer> queue = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                switch(s.charAt(i)) {
                    case '(':
                        queue.add(1);
                        break;
                    case '{':
                        queue.add(2);
                        break;
                    case '[':
                        queue.add(3);
                        break;
                }
            }
            if(s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']'){
                if(queue.isEmpty()){
                    return false;
                }
                int check = queue.pop();
                switch(s.charAt(i)) {
                    case ')':
                        if(check!=1){
                            return false;
                        }
                        break;
                    case '}':
                        if(check!=2){
                            return false;
                        }
                        break;
                    case ']':
                        if(check!=3){
                            return false;
                        }
                        break;
                }
            }
        }

        if(queue.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }
}
