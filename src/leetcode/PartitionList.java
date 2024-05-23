package leetcode;

public class PartitionList {
    public static ListNode partition(ListNode head, int x) {
        ListNode before = null;
        ListNode after = null;
        while (head != null){
            if(head.val < x){
                before = new ListNode(head.val, before);
            } else {
                after = new ListNode(head.val, after);
            }
            head = head.next;
        }
        ListNode answer = null;
        while(after!=null){
            answer = new ListNode(after.val, answer);
            after = after.next;
        }
        while(before!=null){
            answer = new ListNode(before.val, answer);
            before = before.next;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 3, 2, 7};
        ListNode ln = ListNode.listNodefromArray(arr);
        System.out.println(partition(ln,3));
    }
}
