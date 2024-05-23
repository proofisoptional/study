package YandexTasks;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class DataCenters {
    private static final String FILE_INPUT = "input.txt";
    private static final String FILE_OUTPUT = "output.txt";
    private static BufferedReader bufferedReader = null;
    private static BufferedWriter bufferedWriter = null;
    static int dcnum;
    static int servnum;

    public static void main(String[] args) throws IOException {
        bufferedReader = new BufferedReader(new FileReader(FILE_INPUT));
        bufferedWriter = new BufferedWriter(new FileWriter(FILE_OUTPUT));
        String s[] = bufferedReader.readLine().split(" ");
        dcnum = Integer.parseInt(s[0]);
        servnum = Integer.parseInt(s[1]);
        int opernum = Integer.parseInt(s[2]);

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i<opernum; i++){
            String l[] = bufferedReader.readLine().split(" ");
            if(l[0].equals("DISABLE")){
                int datacenter = Integer.parseInt(l[1]);
                int server = Integer.parseInt(l[2]);
                if(!map.containsKey(datacenter)){
                    List<Integer> arr = new ArrayList<>();
                    arr.add(0);
                    arr.add(server);
                    map.put(datacenter, arr);
                } else {
                    List<Integer> arr = map.get(datacenter);
                    if(arr.contains(server) && arr.lastIndexOf(server) != 0){

                    } else {
                        List<Integer> newarr = new ArrayList<>(arr);
                        newarr.add(server);
                        map.put(datacenter, newarr);
                    }
                }
            }
            if(l[0].equals("RESET")){
                int datacenter = Integer.parseInt(l[1]);
                if(map.containsKey(datacenter)){
                    List<Integer> arr = map.get(datacenter);
                    Integer resetcount = arr.get(0);
                    List<Integer> newarr = Arrays.asList(resetcount + 1);
                    map.put(datacenter, newarr);
                } else {
                    List<Integer> arr = Arrays.asList(1);
                    map.put(datacenter, arr);
                }
            }
            if(l[0].equals("GETMAX")){
                long max = 0;
                int dc = 1;
                for(Integer k : map.keySet()){
                    List<Integer> arr = map.get(k);
                    if(arr.get(0) == 0){
                        continue;
                    }
                    long res = arr.get(0) * (servnum - arr.size() + 1);
                    if(res > max){
                        max = res;
                        dc = k;
                    }
                }
                bufferedWriter.write(Integer.toString(dc));
                bufferedWriter.write('\n');
            }
            if(l[0].equals("GETMIN")){
                long min = Long.MAX_VALUE;
                int dc = 1;

                for(int k = 1; k<=dcnum; k++){
                    if(map.containsKey(k)){
                        List<Integer> arr = map.get(k);
                        long res = arr.get(0) * (servnum - arr.size() + 1);
                        if(res<min){
                            min = res;
                            dc = k;
                        }
                        if(res==0){
                            break;
                        }
                    } else {
                        dc = k;
                        break;
                    }
                }
                bufferedWriter.write(Integer.toString(dc));
                bufferedWriter.write('\n');
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
