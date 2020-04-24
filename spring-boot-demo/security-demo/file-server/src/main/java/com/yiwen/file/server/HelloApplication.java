package com.yiwen.file.server;

import com.yiwen.file.server.rmi.impl.RmiServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * @Description
 * @Date 2020年04月12日 10时41分
 * @Created by yiwen
 */
@SpringBootApplication
public class HelloApplication {

    public static void main(String[] args) throws Exception {
        RmiServiceImpl rmiService = new RmiServiceImpl();
        LocateRegistry.createRegistry(1099);
        Naming.bind("rmi://127.0.0.1:6666/rmiExec", rmiService);

        SpringApplication.run(HelloApplication.class, args);
    }

}