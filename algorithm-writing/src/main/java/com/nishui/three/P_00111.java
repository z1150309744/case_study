package com.nishui.three;

import com.common.TreeNode;

/**
 * @Description 二叉树的最小深度
 * @Date 2020年04月08日 10时12分
 * @Created by yiwen
 */
public class P_00111 {

    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        Long minDepth = Long.MAX_VALUE;
        if (root.left != null) {
            minDepth =  Math.min(minDepth(root.left), minDepth);
        }

        if (root.right != null) {
            minDepth = Math.min(minDepth(root.right), minDepth);
        }

        return minDepth.intValue() + 1;
    }

}
