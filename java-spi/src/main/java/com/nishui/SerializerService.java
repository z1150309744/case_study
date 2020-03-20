package com.nishui;

import java.util.Optional;
import java.util.ServiceLoader;
import java.util.stream.StreamSupport;

/**
 * @Description
 * @Date 2020/3/19 9:10 下午
 * @Created by yiwen
 */
public class SerializerService {

    public static void main(String[] args) {
        ServiceLoader<ObjectSerializer> serializers = ServiceLoader.load(ObjectSerializer.class);

        final Optional<ObjectSerializer> serializer = StreamSupport.stream(serializers.spliterator(), false)
                .findFirst();
        serializer.get().serialize("hahah");
    }

}
