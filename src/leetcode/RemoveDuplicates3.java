package leetcode;

public class RemoveDuplicates3 {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode result = new ListNode(head.val);;
        ListNode init = result;
        int lastrepeatnumber = head.val;
        head = head.next;
        while(head!=null){
            if(lastrepeatnumber!=head.val){
                result.next = new ListNode(head.val);
                result = result.next;
                lastrepeatnumber = head.val;
            }
            head = head.next;
        }


        return init;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,2,3,3};
        ListNode listNode = ListNode.listNodefromArray(arr);
        System.out.println(deleteDuplicates(listNode));
    }
}
