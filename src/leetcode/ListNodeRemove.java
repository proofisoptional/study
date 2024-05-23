package leetcode;


import java.util.List;

public class ListNodeRemove {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null){
            return null;
        }
        int length = 1;
        ListNode pivot = head;
        ListNode prevpivot;
        ListNode temp = null;
        while(pivot!=null){
            if(temp==null){
                temp = new ListNode(pivot.val);
            } else {
                temp = new ListNode(pivot.val, temp);
            }
            pivot = pivot.next;
            length++;
        }
        pivot = temp;
        ListNode res = null;
        for(int i = 0; i<length; i++){
            if(n-1 == i){
                pivot = pivot.next;
                if(pivot==null){
                    break;
                }
                res = new ListNode(pivot.val, res);
                i=i+2;
                pivot = pivot.next;
            }
            else {
                res = new ListNode(pivot.val, res);
                pivot = pivot.next;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2};
        ListNode ln = new ListNode(arr[arr.length-1]);
        for(int i = arr.length-1; i>=0; i--){
            if(i==arr.length-1){
                continue;
            }
            else{
                ln = new ListNode(arr[i], ln);
            }
        }
        System.out.println(removeNthFromEnd(ln, 2));

    }
}
