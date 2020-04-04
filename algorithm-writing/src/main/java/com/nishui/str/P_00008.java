package com.nishui.str;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 字符串转换整形
 * @Date 2020年04月03日 19时25分
 * @Created by yiwen
 */
public class P_00008 {

    public static void main(String[] args) {
        System.out.println(new P_00008().myAtoi("   -42"));
    }

    class Automaton {
        public final Integer START = 0;
        public final Integer SIGNED = 1;
        public final Integer NUMBER = 2;
        public final Integer END =3;

        //状态转换存储
        Map<Integer, Integer[]> statMap;

        public Automaton() {
            statMap = new HashMap<>();
            statMap.put(START, new Integer[]{START, SIGNED, NUMBER, END});
            statMap.put(SIGNED, new Integer[]{END, END, NUMBER, END});
            statMap.put(NUMBER, new Integer[]{END, END, NUMBER, END});
            statMap.put(END, new Integer[]{END, END, END, END, END});
        }

        protected boolean isEarlyEnd = false;

        /** 默认为true 表示 +， 否者是 false = **/
        protected boolean sign = true;

        protected long ans = 0;

        public Integer STAT = START;

        public void disposeChar(char c) {
            Integer tmpStat = statMap.get(STAT)[charToStat(c)];

            if (NUMBER.equals(tmpStat)) {
                ans = ans * 10 + c - '0';

                if (sign && ans >= Integer.MAX_VALUE) {
                    ans = Integer.MAX_VALUE;
                    isEarlyEnd = true;
                } else if (!sign && ans > -(long)Integer.MIN_VALUE) {
                    ans = -(long)Integer.MIN_VALUE;
                    isEarlyEnd = true;
                }
            } else if (SIGNED.equals(tmpStat)) {
                sign = c == '+' ? true : false;
            } else if (END.equals(tmpStat)) {
                isEarlyEnd = true;
            }
            STAT = tmpStat;
        }

        public Integer charToStat(char c) {
            if (c == ' ') {
                return 0;
            } else if (c == '+' || c == '-') {
                return 1;
            } else if (c >= '0' && c <= '9') {
                return 2;
            } else {
                return 3;
            }
        }

    }

    public int myAtoi(String str) {

        Automaton automaton = new Automaton();

        for (char c : str.toCharArray()) {
            if (automaton.isEarlyEnd == true) {
                break;
            }

            automaton.disposeChar(c);
        }

        return automaton.sign ? (int) automaton.ans : -(int)automaton.ans;

    }

}