package com.dongyantong.one;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: dongyantong
 * @Date: 2020/3/19
 * @link https://leetcode-cn.com/problems/print-in-order/
 */
public class Multi_Thread_1114 {
    public static void main(String[] args) {

    }

    class Foo {
        private CountDownLatch one = new CountDownLatch(1);
        private CountDownLatch two = new CountDownLatch(1);

        public Foo() {
        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            one.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            // printSecond.run() outputs "second". Do not change or remove this line.
            one.await();
            printSecond.run();
            two.countDown();

        }

        public void third(Runnable printThird) throws InterruptedException {
            // printThird.run() outputs "third". Do not change or remove this line.
            two.await();
            printThird.run();
        }
    }
}
