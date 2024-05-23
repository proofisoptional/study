package leetcode;

public class MergedListNodes {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val < list2.val){
            return new ListNode(list1.val, mergeTwoLists(list1.next, list2));
        } else {
            return new ListNode(list2.val, mergeTwoLists(list1, list2.next));
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[] {1,3,4,6,89,556};
        int[] arr2 = new int[] {7,13,41,223};
        ListNode ln1 = new ListNode(arr1[arr1.length-1]);
        ListNode ln2 = new ListNode(arr2[arr2.length-1]);
        for(int i = arr1.length-1; i>=0; i--){
            if(i==arr1.length-1){
                continue;
            }
            else{
                ln1 = new ListNode(arr1[i], ln1);
            }
        }
        for(int i = arr2.length-1; i>=0; i--){
            if(i==arr2.length-1){
                continue;
            }
            else{
                ln2 = new ListNode(arr2[i], ln2);
            }
        }
        System.out.println(mergeTwoLists(ln1, ln2));
    }
}
