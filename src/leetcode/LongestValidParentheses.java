package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class LongestValidParentheses {
    Map<String, Boolean> mp = new HashMap<>();
    public int longestValidParentheses(String s) {
//        int n = s.length();
//        Stack<Integer> stack = new Stack<>();
//        boolean isVaild = true;
//        for(int  i = 0; i<n; i++){
//            if(s.charAt(i) == '('){
//                stack.push(1);
//            }
//            if(s.charAt(i) == ')'){
//                if(stack.isEmpty()){
//                   isVaild = false;
//                   break;
//                }
//                stack.pop();
//            }
//        }
//        if(stack.isEmpty() && isVaild){
//
//            return s.length();
//        }
//
//        int maxValid = 0;
//        for(int i = 1; i<n; i++){
//            maxValid = Math.max(Math.max(longestValidParentheses(s.substring(0, i)),  longestValidParentheses(s.substring(i))), maxValid);
//        }
//
//        return maxValid;

        List<Integer> list = new ArrayList<>();

        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        for(int  i = 0; i<n; i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }
            if(s.charAt(i) == ')'){
                if(!stack.isEmpty()){
                    int index = stack.pop();
                    list.add(index);
                    list.add(i);

                }
            }
        }
        if(list.isEmpty()){
            return 0;
        }
        Collections.sort(list);
        List<Integer> newList = new ArrayList<>();
        newList.add(list.get(0));
        for(int i = 0; i<list.size()-1; i=i+2){
            if(i>0 && list.get(i) != list.get(i-1)+1){
                newList.add(list.get(i));
            }
            if(i<list.size()-2 && list.get(i+1) != list.get(i+2)-1){
                newList.add(list.get(i+1));
            }
        }
        newList.add(list.get(list.size()-1));
        int maxValue = 0;
        if(newList.size()==2){
            return newList.get(1) - newList.get(0) + 1;
        }
        for(int i = 0; i<newList.size(); i=i+2){
            maxValue = Math.max(maxValue, newList.get(i+1) - newList.get(i) + 1);
        }

        return maxValue;


    }

    public static void main(String[] args) {
        LongestValidParentheses lvp = new LongestValidParentheses();
        System.out.println(lvp.longestValidParentheses(""));
    }
}
