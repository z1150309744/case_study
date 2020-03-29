package com.nishui.thread.locl;

/**
 * @Description
 * @Date 2020年03月28日 21时45分
 * @Created by yiwen
 */
public class SleepThread extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sleep thread end.");
    }

}
