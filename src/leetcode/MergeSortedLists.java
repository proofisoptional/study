package leetcode;

public class MergeSortedLists {
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
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        ListNode res = null;
        for(int i = 0; i<lists.length; i++){
            if(res==null){
                res = lists[i];
                continue;
            }
            ListNode iterator1 = lists[i];
            while(iterator1!=null){
                ListNode iterator2 = res;
                if(iterator1.val<= iterator2.val){
                    iterator2 = new ListNode(iterator1.val, iterator2);
                    res = iterator2;
                } else {
                    while(iterator2.next!=null && iterator1.val > iterator2.next.val){
                        iterator2 = iterator2.next;
                    }
                    if(iterator2.next!=null){
                        ListNode temp = new ListNode(iterator1.val, iterator2.next);
                        iterator2.next = temp;
                    } else {
                        iterator2.next = new ListNode(iterator1.val);
                    }
                }
                iterator1 = iterator1.next;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] arrempty = new int[0];
        int[] arr = new int[]{1, 4, 5};
        int[] arr2 = new int[]{1, 3, 4};
        int[] arr3 = new int[]{2, 6};


        ListNode[] ln = new ListNode[]{listNodefromArray(arrempty), listNodefromArray(arr), listNodefromArray(arr2), listNodefromArray(arr3)};
        System.out.println(mergeKLists(ln));

    }
}
