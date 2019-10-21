import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: 逆水
 * @Descripttion:
 * @Date: 2019年10月18日10时02分
 */
public class SocketMain {

    public static void main(String[] args) throws Exception{

        String host = "localhost";
        int port = 8888;
        // 与服务端建立连接
        Socket socket = new Socket(host, port);
        // 建立连接后获得输出流
        OutputStream outputStream = socket.getOutputStream();
        String message="print" +
                "\n" +
                "Printer" +
                "\n" +
                "test" +
                "\n" +
                "3";
        socket.getOutputStream().write(message.getBytes("UTF-8"));
        outputStream.close();
        socket.close();

    }

}
