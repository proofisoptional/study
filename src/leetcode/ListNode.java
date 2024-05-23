package leetcode;

public class ListNode {
    int val;
    ListNode next;
    public ListNode(){
    }
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
    public static ListNode listNodefromArray(int[] arr){
        if(arr.length==0){
            return null;
        }
        ListNode ln1 = new ListNode(arr[arr.length-1]);
        for(int i = arr.length-1; i>=0; i--){
            if(i==arr.length-1){
                continue;
            }
            else{
                ln1 = new ListNode(arr[i], ln1);
            }
        }
        return ln1;
    }
    public String toString(){
        if(next == null){
            return Integer.toString(val);
        }
        String s = Integer.toString(val) + "->" + next.toString();
        return s;
    }
}
