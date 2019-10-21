import Rule.PrinterRule;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: 逆水
 * @Descripttion:
 * @Date: 2019年10月09日08时44分
 */
public class MyListener extends Thread {

    private static ServerSocket serverSocket;

    private MyTransformer myTransformer;

    private static MyListener myListener = null;

    public MyListener(MyTransformer myTransformer) {
        this.myTransformer = myTransformer;
        setDaemon(true);
    }

    public static synchronized boolean initialize(MyTransformer myTransformer, String hostname, Integer port)
    {
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(hostname, port.intValue()));
            myListener = new MyListener(myTransformer);

            myListener.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void run() {

        while (true) {
            if (serverSocket.isClosed()) {
                return;
            }

            Socket socket = null;
            try {
                socket = serverSocket.accept();
                handleConnection(socket);
            } catch (IOException e) {
                if (!serverSocket.isClosed()) {
                    e.printStackTrace();
                }
                return;
            }

        }

    }

    private void handleConnection(Socket socket)
    {
        try {
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(os));

            String line = in.readLine();

            if (line.equals("print")) {
                handleText(in, out);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    private void handleText(BufferedReader in, PrintWriter out) {
        try {
            String clazzName = in.readLine().trim();
            String methodName = in.readLine().trim();
            int aloadNum = Integer.valueOf(in.readLine().trim());
            PrinterRule printerRule = PrinterRule.builder().clazzName(clazzName)
                    .methodName(methodName)
                    .aloadNum(aloadNum)
                    .build();
            myTransformer.disposeClass(printerRule);
            out.println("disposed.");
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
