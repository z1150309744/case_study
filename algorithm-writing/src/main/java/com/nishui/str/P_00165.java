package com.nishui.str;

import javafx.util.Pair;

/**
 * @Description 比较版本号
 * @Date 2020年04月03日 10时13分
 * @Created by yiwen
 */
public class P_00165 {

    public static void main(String[] args) {
        String version1 = "7.5.2.4", version2 = "7.5.3";
        System.out.println(new P_00165().compareVersion(version1, version2));

    }

    /**
     * 使用双指针
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        int len1, len2;
        if (version1 == null || (len1 = version1.length()) == 0
                || version2 == null || (len2 = version2.length()) == 0) {
            throw new RuntimeException();
        }

        int p1 = 0, p2 = 0;
        int v1, v2;
        while (p1 < len1 || p2 < len2) {
            Pair<Integer, Integer> pair1 = cutOutDigit(version1, len1, p1);
            v1 = pair1.getKey();
            p1 = pair1.getValue();
            Pair<Integer, Integer> pair2 = cutOutDigit(version2, len2, p2);
            v2 = pair2.getKey();
            p2 = pair2.getValue();

            if (v1 != v2) {
                return v1 > v2 ? 1 : -1;
            }
        }
        return 0;
    }

    public Pair<Integer, Integer> cutOutDigit(String cutOutStr, int len, int p) {
        if (p >= len) {
            return new Pair<Integer, Integer>(0, p);
        }

        int incP = p;
        while (incP < len && cutOutStr.charAt(incP) != '.') {
            incP++;
        }

        int res = incP == len -1 ? Integer.valueOf(cutOutStr.substring(p, len))
                : Integer.valueOf(cutOutStr.substring(p, incP));

        return new Pair<Integer, Integer>(res, incP + 1);
    }

}
