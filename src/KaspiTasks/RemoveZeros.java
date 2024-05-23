package KaspiTasks;

import java.util.Arrays;

public class RemoveZeros {
    public static int[] removeFromArray(int[] a) {
        int[] temp = new int[a.length];
        int index = 0;
        for(int i = 0; i<a.length; i++){
            if(a[i]!=0){
                temp[index] = a[i];
                index++;
            }
        }
        int[] result = Arrays.copyOf(temp, index);
        return result;
    }
}
