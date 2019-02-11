package io.github.lucasduete.sd.atividade.performanceRMI.interfaces;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IdentityInterface extends Remote, Serializable {

    public Integer getLimit() throws RemoteException;

    public Integer getIdentity() throws RemoteException;

    public void hasUsed(Integer id) throws RemoteException;

    public void listAllUsedIDs() throws RemoteException;

}
