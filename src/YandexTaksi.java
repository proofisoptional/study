import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class YandexTaksi {
    public static int findMinimum(List<Integer> list){
        if(list==null || list.size() == 0){
            return Integer.MAX_VALUE;
        }
        List<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);

        return sortedList.get(0);
    }

    public static int minBonus(int[] arr){
        Integer sum = 0;
        List<Integer> ratings = new ArrayList<>();
        ratings.add(0);
        int last_calculated = arr[0];
        int last_rating = 0;
        for(int i = 1; i<arr.length; i++){
            if(arr[i] < last_calculated){
                ratings.add(last_rating-1);
                last_rating--;
            } else if(arr[i] > last_calculated) {
                ratings.add(last_rating+1);
                last_rating++;
            } else {
                ratings.add(last_rating);
            }
            last_calculated = arr[i];
        }

        System.out.println(ratings);

        int min = findMinimum(ratings);
        System.out.println(min);
        last_rating = 0;
        int last_sum = (0-min+1)*500;
        System.out.println(last_sum);
        sum = last_sum;
        for(int i = 1; i<ratings.size(); i++){
            if(ratings.get(i)==last_rating && last_sum>500){
                sum = sum+last_sum-500;
                last_rating = ratings.get(i);
                last_sum = last_sum-500;
            } else if(ratings.get(i)==last_rating){
                sum = sum+last_sum;
                last_rating = ratings.get(i);
            } else {
                sum = sum+(ratings.get(i)-min+1)*500;
                last_rating=ratings.get(i);
                last_sum = (ratings.get(i)-min+1)*500;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{4,2,3,3};
//        System.out.println(minBonus(arr));
//        int[] arr2 = new int[]{5,5,5,5};
//        System.out.println(minBonus(arr2));
//        int[] arr3 = new int[]{1,2,3,4};
//        System.out.println(minBonus(arr3));
        int[] arr4 = new int[]{5,5,5,5,4,5,6};
        System.out.println(minBonus(arr4));
    }
}
