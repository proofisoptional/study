package leetcode;

public class SubtreeOfTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean isEqual = false;
        if(root == null && subRoot == null){
            return true;
        }
        if(root == null || subRoot == null){
            return false;
        }
        if(root.val == subRoot.val){
            isEqual = isTreesEquals(root, subRoot);
        }
        if(isEqual){
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    public boolean isTreesEquals(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }
        if(root == null || subRoot == null){
            return false;
        }
        if(root.val != subRoot.val){
            return false;
        }
        return isTreesEquals(root.left, subRoot.left) && isTreesEquals(root.right, subRoot.right);
    }
}
