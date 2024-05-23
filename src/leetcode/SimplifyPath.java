package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        String[] directories = path.split("/");
        List<String> paths = new ArrayList<>();
        for(String s: directories){
            if(s.equals("..")){
                if(paths.size() == 0){
                    continue;
                }
                paths.remove(paths.size() - 1);
                continue;
            }
            if(s.equals(".")){
                continue;
            }
            if(!s.isEmpty()){
                paths.add(s);
            }

        }

        StringBuilder sb = new StringBuilder();
        sb.append("/");
        for(String s:paths){
            sb.append(s);
            sb.append("/");
        }
        if(paths.size()!=0){
            sb.deleteCharAt(sb.length()-1);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }
}
