package com.nishui;

/**
 * @Description java 序列化具体实现
 * @Date 2020/3/19 9:07 下午
 * @Created by yiwen
 */
public class JavaSerializer implements ObjectSerializer {

    @Override
    public void serialize(String obj) {
        System.out.println("java serializer:" + obj);
    }
}
