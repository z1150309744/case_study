package com.nishui.bisai;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description II. 从上到下打印二叉树 II
 * @Date 2020年04月06日 20时29分
 * @Created by yiwen
 */
public class P_00032 {
    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 29.46%\100.00%
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> masterQueue = new LinkedList<>();
        Queue<TreeNode> backupQuene = new LinkedList<>();
        masterQueue.add(root);

        while (masterQueue.size() != 0 || backupQuene.size() != 0) {
            List<Integer> tmpList = new ArrayList<>();
            while (masterQueue.size() != 0) {
                TreeNode tn = masterQueue.poll();
                tmpList.add(tn.val);
                if (tn.left != null) {
                    backupQuene.offer(tn.left);
                }
                if (tn.right != null) {
                    backupQuene.offer(tn.right);
                }
            }
            masterQueue = backupQuene;
            backupQuene = new LinkedList<>();
            ans.add(tmpList);
        }
        return ans;
    }

}
