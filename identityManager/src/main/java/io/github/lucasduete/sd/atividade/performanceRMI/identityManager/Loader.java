package io.github.lucasduete.sd.atividade.performanceRMI.identityManager;

import io.github.lucasduete.sd.atividade.performanceRMI.interfaces.IdentityInterface;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class Loader {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        IdentityInterface manager = new IdentifyManager();

        LocateRegistry.createRegistry(10099).bind("IdentifyManager", manager);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Pressione enter para parar e listar IDs usados");

        scanner.nextLine();
        manager.listAllUsedIDs();
    }

}
