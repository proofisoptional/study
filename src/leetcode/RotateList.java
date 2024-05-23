package leetcode;

public class RotateList {
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        if(k==0 || head.next==null){
            return head;
        }
        ListNode temp = new ListNode(head.val, head.next);
        if(head.next.next == null){
            k = k%2;
            if(k==0){
                return head;
            } else {
                ListNode res = new ListNode(head.next.val);
                head.next = null;
                res.next = head;
                return res;
            }
        }

        int count = 2;
        while(head.next.next != null){
            head = head.next;
            count++;
        }
        if(k>count){
            k = k%count;
            if(k==0){
                return temp;
            }
        }
        ListNode newNode = new ListNode(head.next.val);
        head.next = null;
        newNode.next = temp;
        return rotateRight(newNode, k - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2};
        ListNode temp = ListNode.listNodefromArray(arr);
        System.out.println(rotateRight(temp, 2).toString());
    }
}
