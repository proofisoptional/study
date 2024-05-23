package leetcode;

public class SwapNodes {
    public static ListNode swapPairs(ListNode head) {
        ListNode current = head;
        ListNode res = null;
        ListNode temp = null;
        while(current!=null && current.next!=null){
            ListNode pair1 = current;
            ListNode pair2 = current.next;
            pair1.next = pair2.next;
            pair2.next = pair1;
            if(temp!=null){
                temp = temp.next;
                temp.next = new ListNode(pair2.val, pair2.next);
            }
            temp = new ListNode(pair2.val, pair2.next);
            current = pair1.next;
            if(res == null){
                res = temp;
            }
        }
        if(res==null){
            res = head;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1};
        ListNode ln = ListNode.listNodefromArray(arr);
        System.out.println(swapPairs(ln));
    }
}
