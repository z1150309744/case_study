package com.yiwen.file.server.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Description
 * @Date 2020年04月12日 13时10分
 * @Created by yiwen
 */
public interface RmiService extends Remote {

    String exec() throws RemoteException;

}
