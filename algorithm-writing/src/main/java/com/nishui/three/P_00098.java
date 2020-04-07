package com.nishui.three;

import com.common.TreeNode;

/**
 * @Description 验证二叉搜索树
 * @Date 2020年04月07日 23时21分
 * @Created by yiwen
 */
public class P_00098 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer lower, Integer upper) {
        //终止条件
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        //递归left\right子节点  左上和右上数据 差 一层节点
        if (!isValidBST(root.left, lower, val)) {
            return false;
        }
        if (!isValidBST(root.right, val, upper)) {
            return false;
        }
        return true;
    }

}
