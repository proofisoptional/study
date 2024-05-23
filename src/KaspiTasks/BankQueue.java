package KaspiTasks;

import java.util.ArrayList;
import java.util.List;

public class BankQueue {
    public static int[] queueAtTheBank(int n, String[] requests) {

        List<Integer> queue = new ArrayList<>();
        List<Integer> output = new ArrayList<>();

        for(int i = 0; i< requests.length; i++){
            if(requests[i].contains("SERVED")){
                output.add(queue.remove(0));
            } else if(requests[i].contains("VIP")){
                String[] temp = requests[i].split(" ");
                if(queue.size() == 0 || queue.size() == 1){
                    queue.add(Integer.parseInt(temp[1]));
                } else {
                    int mid = queue.size()/2;
                    if(queue.size()%2==1){
                        mid = queue.size()/2 + 1;
                    }
                    queue.add(mid, Integer.parseInt(temp[1]));
                }
            } else {
                queue.add(Integer.parseInt(requests[i]));
            }
        }
        int[] res = new int[output.size()];
        for(int i = 0; i<output.size(); i++){
            res[i] = output.get(i);
        }

        return res;

    }

    public static void main(String[] args) {
        String[] data = {
                "VIP 44", "38", "VIP 32", "5", "11", "34", "32", "VIP 16", "31", "17",
                "SERVED", "SERVED", "43", "1", "VIP 4", "10", "22", "SERVED", "47",
                "SERVED", "3", "SERVED", "SERVED", "SERVED", "SERVED", "4", "45", "VIP 28",
                "28", "49", "VIP 8", "SERVED", "30", "14", "VIP 20", "20", "15", "6",
                "46", "13", "29", "19", "SERVED", "27", "VIP 48", "50", "VIP 40", "VIP 36",
                "41", "23"
        };
        int[] temp = queueAtTheBank(data.length, data);
        System.out.println("done");
    }
}
