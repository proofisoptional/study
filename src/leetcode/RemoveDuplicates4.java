package leetcode;

public class RemoveDuplicates4 {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode init = null;
        ListNode result = null;
        int lastrepeatnumber = head.val;
        while(head.next!=null){
            lastrepeatnumber = head.val;
            if(head.val==head.next.val){
                head = head.next;
            } else {
                if(result == null){
                    result = new ListNode(head.val);
                    init = result;
                } else {
                    result.next = new ListNode(head.val);
                    result = result.next;
                }
                head = head.next;
            }

        }

        if(head.val != lastrepeatnumber){
            if(result == null){
                result = new ListNode(head.val);
                init = result;
            } else {
                result.next = new ListNode(head.val);
            }
        }

        return init;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,2,3,3,3,4};
        ListNode listNode = ListNode.listNodefromArray(arr);
        System.out.println(deleteDuplicates(listNode));
    }
}
