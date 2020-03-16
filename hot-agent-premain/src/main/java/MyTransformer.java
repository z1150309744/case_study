import Rule.GlobalRule;
import Rule.PrinterRule;
import Rule.Rule;
import adapter.PrinterClassVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

/**
 * @Author: 逆水
 * @Descripttion:
 * @Date: 2019年10月04日17时51分
 */
public class MyTransformer implements ClassFileTransformer {

    private Instrumentation inst;

    private Boolean init = true;

    public MyTransformer(Instrumentation inst) {
        this.inst = inst;
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (!init) {
            Rule rule = GlobalRule.globalRuleMap.get(className.replaceAll("/", "."));
            if (rule != null && rule instanceof PrinterRule) {
                //使用 asm 进行修改
                byte[] newBuffer = classfileBuffer;
                ClassReader cr = new ClassReader(newBuffer);
                ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
                PrinterClassVisitor visitor = new PrinterClassVisitor(cw, (PrinterRule) rule);
                cr.accept(visitor, ClassReader.EXPAND_FRAMES);

                //jvm 提供的方法能够 重定义字节码
                return cw.toByteArray();
            }
        }
        return null;
    }

    public void disposeClass(PrinterRule printerRule) throws Exception
    {
        if (init) {
            init = false;
        }

        GlobalRule.globalRuleMap.put(printerRule.getClazzName(), printerRule);

        System.out.println("printerRule:" + printerRule);
        Class<?>[] transformedArray = new Class<?>[1];
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class clazz = loader.loadClass(printerRule.getClazzName());
        transformedArray[0] = clazz;
        //重转换提供的类集
        inst.retransformClasses(transformedArray);

    }

}
