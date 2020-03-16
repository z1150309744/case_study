import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;
import java.util.List;

/**
 * @Author: 逆水
 * @Descripttion:
 * @Date: 2019年10月20日13时32分
 */
public class Install {
    private String agentJar = null;
    private String mainClassName = null;
    private VirtualMachine vm;

    public static void main(String[] args) throws Exception {
        Install install = new Install();

        install.parseArgs(args);
        install.attach();
        install.injectAgent();
    }

    //解析数据 simple
    private void parseArgs(String[] args) {
        agentJar = args[0];
        mainClassName = args[1];
    }

    // 通过匹配运行main方法类
    private void attach() throws Exception {
        List<VirtualMachineDescriptor> vmds = VirtualMachine.list();
        for (VirtualMachineDescriptor vmd: vmds) {
            String displayName = vmd.displayName();
            int spacePos = displayName.indexOf(' ');
            if (spacePos > 0) {
                displayName = displayName.substring(0, spacePos);
            }
            if (this.mainClassName.equals(displayName)) {
                vm = VirtualMachine.attach(vmd);
                return;
            }
        }
    }

    private void injectAgent() throws Exception {
        try {
            vm.loadAgent(agentJar, null);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            vm.detach();
        }
    }

}
