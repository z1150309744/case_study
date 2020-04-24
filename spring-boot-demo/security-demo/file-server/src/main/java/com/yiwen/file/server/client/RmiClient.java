package com.yiwen.file.server.client;

import com.yiwen.file.server.rmi.RmiService;

import java.rmi.Naming;

/**
 * @Description
 * @Date 2020年04月12日 13时14分
 * @Created by yiwen
 */
public class RmiClient {

    public static void main(String[] args) throws Exception {
        RmiService rmiService = (RmiService) Naming.lookup("rmi://127.0.0.1:6666/rmiExec");
        System.out.println(rmiService.exec());
    }

}
