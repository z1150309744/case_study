package com.nishui.two;

/**
 * @Description 最长公共前缀
 * @Date 2020年04月05日 21时54分
 * @Created by yiwen
 */
public class P_00014 {

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(new P_00014().longestCommonPrefix(strs));
    }

    /**
     * 分治
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    public String longestCommonPrefix(String[] strs, int left, int right) {
        //结束条件
        if (left == right) {
            return strs[left];
        } else {
            int mid = (right + left) / 2;
            String leftStr = longestCommonPrefix(strs, left, mid );
            String rightStr = longestCommonPrefix(strs, mid + 1, right);
            return commonPrefix(leftStr, rightStr);
        }
    }

    public String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }

}
