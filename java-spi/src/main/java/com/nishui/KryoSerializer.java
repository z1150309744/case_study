package com.nishui;

/**
 * @Description Kryo序列花具体实现
 * @Date 2020/3/19 9:05 下午
 * @Created by yiwen
 */
public class KryoSerializer implements ObjectSerializer {

    @Override
    public void serialize(String obj) {
        System.out.println("Kryo serializer:" + obj);
    }
}
