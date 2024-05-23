//https://leetcode.com/problems/reverse-nodes-in-k-group/
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReverseNodesInKGroups {
    public static ArrayList<ListNode> reverseListNode(ListNode head, int k){
        ArrayList<ListNode> answer = new ArrayList<>();
        ArrayList<ListNode> headList = new ArrayList<>();
        headList.add(head);
        ListNode iterator = new ListNode(head.val, head.next);
        ListNode current = new ListNode(head.val);
        ListNode last = new ListNode();
        int i = 0;
        while(i<k-1){
            if(iterator.next == null){
                return headList;
            }
            ListNode prev = new ListNode(current.val, current.next);
            if(i == 0){
                last = prev;
            }
            current = new ListNode(iterator.next.val, prev);
            iterator = iterator.next;
            i++;
        }
        answer.add(current);
        answer.add(last);
        answer.add(iterator.next);

        return answer;

    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(k==1){
            return head;
        }
        ArrayList<ListNode> temp = reverseListNode(head, k);
        if(temp.size()==1){
            return temp.get(0);
        }
        ListNode start = temp.get(0);
        while(temp.size()>1){
            ListNode last = temp.get(1);
            ListNode reversed = temp.get(2);
            if(reversed==null){
                return start;
            }
            temp = reverseListNode(reversed, k);
            last.next = temp.get(0);
        }
        return start;
    }

    public static void main(String[] args) {
        /*int[] arr = new int[]{1, 6, 8, 4, 5};*/
        int[] arr = new int[]{1, 2};
        ListNode ln = ListNode.listNodefromArray(arr);
        ArrayList<ListNode> listnodes = new ArrayList<>();
        System.out.println(reverseKGroup(ln, 2));

    }
}
