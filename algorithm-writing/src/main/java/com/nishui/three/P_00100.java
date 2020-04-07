package com.nishui.three;

import com.common.TreeNode;

/**
 * @Description 相同的树
 * @Date 2020年04月07日 08时10分
 * @Created by yiwen
 */
public class P_00100 {
    public static void main(String[] args) {

    }

    /**
     * 递归
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
