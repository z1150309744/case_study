package com.nishui.thread.locl;

/**
 * @Description sleep 的使用
 * @Date 2020年03月28日 21时43分
 * @Created by yiwen
 */
public class SleepUsage {

    public static void main(String[] args) throws Exception {
        SleepThread sleepThread = new SleepThread();
        sleepThread.start();

        System.out.println("sleep thread is start");

        sleepThread.interrupt();
        System.out.println("main is end.");
    }

    public static void sleepExample() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println(
                "Thread '" + Thread.currentThread().getName() +
                        "' is woken after sleeping for 1 second");
    }

}
