package io.github.lucasduete.sd.atividade.performanceRMI.identityManager;

import io.github.lucasduete.sd.atividade.performanceRMI.interfaces.IdentityInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class IdentifyManager extends UnicastRemoteObject implements IdentityInterface {

    private static final Integer LIMIT = 1000;
    private static final AtomicInteger counter = new AtomicInteger(0);

    private final Map<Integer, Boolean> idsUsed;

    protected IdentifyManager() throws RemoteException {
        this.idsUsed = loadMap();
    }

    @Override
    public Integer getLimit() throws RemoteException {
        return LIMIT;
    }

    @Override
    public Integer getIdentity() throws RemoteException {
        return counter.getAndIncrement();
    }

    @Override
    public void hasUsed(final Integer id) throws RemoteException {
        this.idsUsed.replace(id, true);
    }

    @Override
    public void listAllUsedIDs() throws RemoteException {
        this.idsUsed.entrySet()
                .stream()
                .filter(Map.Entry::getValue)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
                .forEach((integer, aBoolean) -> System.out.println(integer + " , " + aBoolean));
    }

    private Map<Integer, Boolean> loadMap() {

        final Map<Integer, Boolean> mapIdsUsed = new HashMap<>();

        for (int i = 0; i < LIMIT; i++) mapIdsUsed.put(i, false);

        return mapIdsUsed;
    }

}
