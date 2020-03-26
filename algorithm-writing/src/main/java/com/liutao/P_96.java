package com.liutao;

/**
 * Author liutao
 * Date 2020/3/25 7:52 下午
 * Description:
 * Version: 1.0
 * 二叉查找树（Binary Search Tree），
 * （又：二叉搜索树，二叉排序树）它或者是一棵空树，或者是具有下列性质的二叉树：
 * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 * 它的左、右子树也分别为二叉排序树。
 **/
public class P_96 {
    public static void main(String[] args) {

        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        int[] data = new int[n + 1];
        data[0] = 1;
        data[1] = 1;
        for (int i = 2; i <data.length; ++i) {
            for (int j = 1; j <=i; ++j) {
             //   System.out.println("[j-1]data["+(j - 1)+"]:"+data[j - 1]+"  [i - j]data["+(i - j)+"]:" +data[i - j]+"   [i]data["+i+"]:"+data[i]);
                data[i] += data[j - 1] * data[i - j];
            }

        }
        return data[n];

    }
}
