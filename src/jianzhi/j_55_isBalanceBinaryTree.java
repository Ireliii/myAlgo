package jianzhi;

import java.lang.reflect.Parameter;

/**
 * @author 86184
 * @date 2022-11-2022/11/2-17:29
 */
public class j_55_isBalanceBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(3);
        TreeNode t7 = new TreeNode(3);
        root.left = t1;
        root.right = t2;
        t2.right = t3;
        t3.right = t4;
//        System.out.println(is(root));
    }

    public boolean is(TreeNode root){

        if(root == null)
            return true;

        boolean l = is(root.left);
        boolean r = is(root.right);

        int lH = getHeight(root.left);
        int rH = getHeight(root.right);

        boolean self = Math.abs(lH-rH)<2;

        return self&&r&&l;
    }

    public int getHeight(TreeNode node){
        if(node == null)
            return 0;
        int l = getHeight(node.left);
        int r = getHeight(node.right);
        return Math.max(l+1,r+1);
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
