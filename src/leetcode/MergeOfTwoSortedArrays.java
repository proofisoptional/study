package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

public class MergeOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        double res;
        List<Integer> merge = new ArrayList<>();
        int len = nums1.length + nums2.length;
        int index1 = 0;
        int index2 = 0;
        if(nums1.length == 0 || nums2.length ==0){
            if(nums1.length == 0){
                for(int i = 0; i < nums2.length; i++){
                    merge.add(nums2[i]);
                }
            } else if(nums2.length == 0){
                for(int i = 0; i < nums1.length; i++){
                    merge.add(nums1[i]);
                }
            }
        } else {
            for (int i = 0; i < len; i++) {
                if (nums1[index1] < nums2[index2]) {
                    merge.add(nums1[index1]);
                    index1++;
                } else {
                    merge.add(nums2[index2]);
                    index2++;
                }
                if (index2 == nums2.length) {
                    while (index1 < nums1.length) {
                        merge.add(nums1[index1]);
                        index1++;
                    }
                    break;
                }
                if (index1 == nums1.length) {
                    while (index2 < nums2.length) {
                        merge.add(nums2[index2]);
                        index2++;
                    }
                    break;
                }

            }
        }
        if(merge.size()%2==0){
            int temp = merge.size()/2;
            res = (double)(merge.get(temp) + merge.get(temp - 1))/2;
        } else {
            int temp = merge.size()/2;
            res = merge.get(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] n1 = new int[] {1, 3};
        int[] n2 = new int[] {2};
        System.out.println(findMedianSortedArrays(n1, n2));
    }
}
