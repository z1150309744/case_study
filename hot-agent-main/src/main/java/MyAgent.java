import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Author: 逆水
 * @Descripttion:
 * @Date: 2019年10月02日09时16分
 */
public class MyAgent {

    private static final String TRANSFORMER_NAME = "MyTransformer";
    private static final String LISTENER_NAME = "MyListener";

    private static final String defualtHost = "localhost";
    private static final Integer defualtPort = 8888;

    public static void premain(String args, Instrumentation inst)
            throws Exception
    {

    }

    public static void agentmain(String args, Instrumentation inst)
            throws Exception {
        System.out.println("agentArgs : " + args);

        ClassFileTransformer transformer;
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class/*<Transformer>*/ transformerClazz = loader.loadClass(TRANSFORMER_NAME);
        Constructor/*<Transformer>*/ constructor = transformerClazz.getConstructor(Instrumentation.class);
        transformer = (ClassFileTransformer)constructor.newInstance(new Object[] { inst});

        Class myListenerClazz = loader.loadClass(LISTENER_NAME);
        Method method = myListenerClazz.getMethod("initialize", transformerClazz, String.class, Integer.class);
        method.invoke(null, transformer, defualtHost, defualtPort);

        /**
         * 注册提供的转换器
         */
        inst.addTransformer(transformer, true);
    }

}
