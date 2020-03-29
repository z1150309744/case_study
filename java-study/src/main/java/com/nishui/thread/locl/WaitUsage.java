package com.nishui.thread.locl;

/**
 * @Description wait 的使用
 * @Date 2020年03月28日 21时40分
 * @Created by yiwen
 */

public class WaitUsage {

    private static Object LOCK = new Object();

    public static void main(String[] args) throws Exception {
        WaitUsage.WaitExample();
        System.out.println("main is end");
    }

    public static void WaitExample() throws InterruptedException {
        synchronized (LOCK) {
            LOCK.wait(1000);
            System.out.println("Object '" + LOCK + "' is woken after" +
                    " waiting for 1 second");
        }
    }

}
