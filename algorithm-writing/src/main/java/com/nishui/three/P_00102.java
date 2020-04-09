package com.nishui.three;

import com.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 二叉树的层序遍历
 * @Date 2020年04月08日 23时19分
 * @Created by yiwen
 */
public class P_00102 {

    //BFS  迭代
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int len = queue.size();

            List<Integer> tmpList = new ArrayList<>();
            int i = 0;
            while (i < len) {
                root = queue.poll();
                tmpList.add(root.val);
                i++;
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }
            ans.add(tmpList);
        }
        return ans;
    }

}
