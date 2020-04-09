package com.liutao.three;

import java.util.Stack;

/**
 * Author liutao
 * Date 2020/4/8 11:22 下午
 * Description:
 * Version: 1.0
 **/
public class MyQueue {

    private Stack<Integer> inPut;
    private Stack<Integer> outPut;

    private int front;
    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        inPut = new Stack<>();
        outPut = new Stack<>();
    }


    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inPut.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
            //将输入栈中的数据加入到
            if (outPut.isEmpty()) {
                while (!inPut.isEmpty()) {
                    outPut.push(inPut.pop());
                }
            }
        return outPut.pop();

    }

    /**
     * Get the front element.
     */
    public int peek() {
        if(outPut.isEmpty()){
            while (!inPut.isEmpty()){
                outPut.push(inPut.pop());
            }
        }

        return outPut.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return inPut.size() == 0 && outPut.size() == 0;
    }
}
