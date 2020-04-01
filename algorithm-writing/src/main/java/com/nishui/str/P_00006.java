package com.nishui.str;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description Z 字形变换
 * @Date 2020年04月01日 09时24分
 * @Created by yiwen
 */
public class P_00006 {

    public static void main(String[] args) {
        String s = "AB";
        String conpareStr = "LCIRETOESIIGEDHN";

        System.out.println(new P_00006().s(s, 1).equals(conpareStr));
    }

    public String s(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    public String convert(String s, int numRows) {
        int len;
        if (s == null || (len = s.length()) <= 1 || numRows == 1) {
            return s;
        }

        /**
         * 构造数据结构，初始化容量
         */
        int capacity = Math.min(numRows, len);
        List<String> rows = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            rows.add("");
        }


        /**
         * 需要有记录方向的,目前只有上下两个方向
         * 需要记录当前行的
         */
        boolean isDown = false;
        int curRow = 0;

        for (int i = 0 ; i < len; i++) {
            String tmpStr = rows.get(curRow) + s.charAt(i);
            rows.set(curRow, tmpStr);

            //处理方向和行
            if (curRow == 0 || curRow == numRows - 1) {
                isDown = !isDown;
            }

            curRow += isDown ? 1 : -1;
        }

        String ret = "";
        for (String tmpStr : rows) {
            ret += tmpStr;
        }
        return ret;
    }

}
