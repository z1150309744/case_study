package com.nishui.thread.join;

public class JoinThreadMain {

    public static void main(String[] args) {
        //循环五次
        for (int i = 0; i < 5; i++) {

            MyThread thread = new MyThread();
            //启动线程
            thread.start();
            try {
                //调用join()方法
                thread.join(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主线程执行完毕");
            System.out.println("~~~~~~~~~~~~~~~");
        }

    }

}
