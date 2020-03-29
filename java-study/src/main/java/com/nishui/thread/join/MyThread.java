package com.nishui.thread.join;

public class MyThread extends Thread {

    @Override
    public void run() {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("子线程执行完毕");
    }

}
