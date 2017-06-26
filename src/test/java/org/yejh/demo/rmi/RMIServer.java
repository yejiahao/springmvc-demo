package org.yejh.demo.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            RMIServerService service = new RMIServerServiceImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("firstRMI", service);
            System.out.println("server registry 1 RMIService Object");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
