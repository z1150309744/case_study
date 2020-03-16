package adapter;

import Rule.PrinterRule;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

import static org.objectweb.asm.Opcodes.ASM5;

/**
 * @Author: 逆水
 * @Descripttion:
 * @Date: 2019年10月18日09时15分
 */
public class PrinterClassVisitor extends ClassVisitor {

    private PrinterRule rule;

    public PrinterClassVisitor(ClassVisitor classVisitor, PrinterRule rule) {
        super(ASM5, classVisitor);
        this.rule = rule;
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        if (cv != null) {
            cv.visit(version, access, name, signature, superName, interfaces);
        }
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        //如果methodName是newFunc，则返回我们自定义的TestMethodVisitor
        if (rule.getMethodName().equals(name)) {
            MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
            return new PrinterMethodAdapter(mv, rule);
        }
        if (cv != null) {
            return cv.visitMethod(access, name, desc, signature, exceptions);
        }

        return null;
    }

}
