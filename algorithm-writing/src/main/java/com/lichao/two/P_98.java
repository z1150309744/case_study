package com.lichao.two;

/**
 * describe:
 *
 * @author lichao
 * @date 2019/03/26
 */
public class P_98 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static Long num = Long.MIN_VALUE;
    public static boolean isValidBST(TreeNode root) {
        num = Long.MIN_VALUE;
       return isValidBSTStatic(root);
    }
    public static boolean isValidBSTStatic(TreeNode root) {
        if(root == null){
            return true;
        }
        if(!isValidBSTStatic(root.left)){
            return false;
        }
        if(root.val <= num){
            return false;
        }else{
            num = Long.valueOf(root.val);
        }
        if(!isValidBSTStatic(root.right)){
            return false;
        }
        return true;
    }

    public static void main(String [] args){
        TreeNode node = new TreeNode(0);
        System.out.println(isValidBST(node));
    }
}
