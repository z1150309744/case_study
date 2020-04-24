package com.yiwen.file.server.rmi.impl;

import com.yiwen.file.server.rmi.RmiService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Description TODO
 * @Date 2020年04月12日 13时10分
 * @Created by yiwen
 */
public class RmiServiceImpl extends UnicastRemoteObject implements RmiService {

    public RmiServiceImpl() throws RemoteException{
        super();
    }

    @Override
    public String exec() throws RemoteException {
        try {
            Runtime rt = Runtime.getRuntime();
            String[] commands = {"touch", "/tmp/success"};
            Process pc = rt.exec(commands);
            pc.waitFor();
        } catch (Exception e) {
            // do nothing
        }
        return "success";
    }

}
