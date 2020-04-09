package com.nishui.three;

import com.common.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 二叉树的最大深度
 * @Date 2020年04月08日 11时23分
 * @Created by yiwen
 */
public class P_00104 {

    public static void main(String[] args) {

    }

    //迭代
    public int maxDepth2(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root != null) {
            stack.add(new Pair<>(root, 1));
        }

        int maxDepth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> curr = stack.poll();
            root = curr.getKey();
            int depth = curr.getValue();

            if (root != null) {
                maxDepth = Math.max(maxDepth, depth);
                stack.add(new Pair<>(root.left, depth + 1));
                stack.add(new Pair<>(root.right, depth + 1));
            }
        }
        return maxDepth;
    }

    //递归
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftMaxDepth = maxDepth(root.left);
            int rightMaxDepth = maxDepth(root.right);
            return Math.max(leftMaxDepth, rightMaxDepth) + 1;
        }
    }


}