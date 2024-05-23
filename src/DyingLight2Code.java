import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class DyingLight2Code {
    public static String decode(String s){
        Map<String, String> codes = new HashMap<>();
        codes.put("AAAAA", "A");
        codes.put("AAAAB", "B");
        codes.put("AAABA", "C");
        codes.put("AAABB", "D");
        codes.put("AABAA", "E");
        codes.put("AABAB", "F");
        codes.put("AABBA", "G");
        codes.put("AABBB", "H");
        codes.put("ABAAA", "I/J");
        codes.put("ABAAB", "K");
        codes.put("ABABA", "L");
        codes.put("ABABB", "M");
        codes.put("ABBAA", "N");
        codes.put("ABBAB", "O");
        codes.put("ABBBA", "P");
        codes.put("ABBBB", "Q");
        codes.put("BAAAA", "R");
        codes.put("BAAAB", "S");
        codes.put("BAABA", "T");
        codes.put("BAABB", "U/V");
        codes.put("BABAA", "W");
        codes.put("BABAB", "X");
        codes.put("BABBA", "Y");
        codes.put("BABBB", "Z");
        System.out.println("success");

        StringBuilder buffer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == ' ' || s.charAt(i) == '\n'){
                sb.append(s.charAt(i));
                continue;
            }
            buffer.append(s.charAt(i));
            if(buffer.length() == 5){
                sb.append(codes.get(buffer.toString()));
                buffer = new StringBuilder();
            }


        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String code = "ABABBBAABBAAABBAAABBBABBA\n" +
                "AABBABAAAAABBABBAABBABBAAAAABBBAAAB ABBBAABBABAAABBBAABBAAAAAABABA\n" +
                "BAABBABBABAAABBABBABABBAAAAAAAABBBAABBABBAAAAABA\n" +
                "ABAAAAA ABBAABAABBABABA BAABABAAAAABAAA\n" +
                "AAABBBAABBAAAAA ABBABAAABBABAAAABBAA\n" +
                "BAAABAAABAAABBBAABAABAAABBAABA BAAABAABAAABABB";

        System.out.println(decode(code));
    }
}
