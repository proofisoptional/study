import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {

    public static int compare (String str1, String str2){
        if(str1.length()!=str2.length()){
            return 9999999;
        }
        for(int i = 0; i<str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                return i;
            }
        }
        return -1;
    }


    public static String uniqueChars(String str){
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        for(int i = 1; i<str.length(); i++){
            if(str.charAt(i)!=str.charAt(i-1)){
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public void processData(List<String> arrays, String s){
        if(s.equals("ssss")){
            arrays.add("dss");
            arrays.add("qsss");
        }
    }



    public static void main(String[] args) {
        String s= "100";
        String s1= "100";

        Map<String, Integer> sMap=new HashMap<>();

        sMap.put(s, 100);
        sMap.put(s1, 101);

        System.out.println(sMap.get(s));
    }
}
