/**
 * @Author: 逆水
 * @Descripttion:
 * @Date: 2019年10月10日09时57分
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Printer printer = new Printer();
        while (true) {
            Thread.sleep(1000);
            printer.test("t---");
        }
    }

}
