/**
 * @Author: 逆水
 * @Descripttion:
 * @Date: 2019年10月01日23时18分
 */
public class Main {

    public static void main(String[] args) throws Exception {

        while (true) {
            CustomClassloader customClassloader = new CustomClassloader();
            Class clazz = customClassloader.loadClass("PrintTest");
            Object printTest = clazz.newInstance();
            printTest.getClass().getMethod("print", new Class[]{}).invoke(printTest);

            Thread.sleep(2000);
        }
    }

}
