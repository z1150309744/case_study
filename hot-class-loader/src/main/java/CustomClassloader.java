import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: 逆水
 * @Descripttion:
 * @Date: 2019年10月01日23时15分
 */
public class CustomClassloader extends ClassLoader {

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        try {
            String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";

            InputStream is = getClass().getResourceAsStream(fileName);
            if (is == null) {
                return super.loadClass(name);
            }

            byte[] b = new byte[is.available()];

            is.read(b);
            return defineClass(name, b, 0, b.length);

        } catch (IOException e) {
            e.printStackTrace();
            throw new ClassNotFoundException(name);
        }
    }
}
