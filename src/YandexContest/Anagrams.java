package YandexContest;

import java.io.*;
import java.util.HashMap;

public class Anagrams {
    private static final String FILE_INPUT = "input.txt";
    private static final String FILE_OUTPUT = "output.txt";
    private static BufferedReader bufferedReader = null;
    private static BufferedWriter bufferedWriter = null;

    public static void main(String[] args) throws IOException {
        bufferedReader = new BufferedReader(new FileReader(FILE_INPUT));
        boolean areSame = true;
        HashMap<Integer, Integer> map = new HashMap<>();
        int c;
        while((c = bufferedReader.read()) != 10 && c != 13){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
                continue;
            }
            map.put(c, 1);
        }
        while((c = bufferedReader.read()) != -1){
            if(c == 10 || c == 13){
                continue;
            }
            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
            } else {
                areSame = false;
                break;
            }
        }
        if(areSame){
           for(int s: map.values()){
               if(s!=0){
                   areSame = false;
                   break;
               }
           }
        }
        bufferedReader.close();
        bufferedWriter = new BufferedWriter(new FileWriter(FILE_OUTPUT));
        if(areSame){
            bufferedWriter.write('1');
        } else {
            bufferedWriter.write('0');
        }
        bufferedWriter.close();
    }
}
