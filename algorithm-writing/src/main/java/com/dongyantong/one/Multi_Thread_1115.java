package com.dongyantong.one;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: dongyantong
 * @Date: 2020/3/19
 * @link https://leetcode-cn.com/problems/print-foobar-alternately/
 */
public class Multi_Thread_1115 {
    public static void main(String[] args) {

    }

    class FooBar {
        private int n;

        private CountDownLatch order = new CountDownLatch(1);

        private CyclicBarrier barrier = new CyclicBarrier(2);


        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                try {

                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    order.countDown();
                    barrier.await();
                } catch (Exception e) {
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                try {
                    order.await();
                    printBar.run();
                    order = new CountDownLatch(1);
                    barrier.await();
                } catch (Exception e) {
                }

            }
        }
    }
}
