package adapter;

import Rule.PrinterRule;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import static org.objectweb.asm.Opcodes.*;

/**
 * @Author: 逆水
 * @Descripttion:
 * @Date: 2019年10月11日09时52分
 */
public class PrinterMethodAdapter extends MethodVisitor {

    private PrinterRule rule;

    public PrinterMethodAdapter(MethodVisitor mv, PrinterRule rule) {
        super(ASM5, mv);
        this.rule = rule;
    }

    @Override
    public void visitCode() {
        //方法体内开始时调用
        super.visitCode();
    }

    @Override
    public void visitInsn(int opcode) {
        if (opcode == Opcodes.RETURN) {
            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(ALOAD, rule.getAloadNum());
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        }
        //每执行一个指令都会调用
        super.visitInsn(opcode);
    }
}
