package org.yejh.demo.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class RMIServerServiceImpl extends UnicastRemoteObject implements RMIServerService {

	protected RMIServerServiceImpl() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public String echo(String msg) throws RemoteException {
		return "来自老师： " + msg;
	}

	@Override
	public String echo(String yourNo, byte[] yourName) throws RemoteException {
		return "yourName";
	}

	@Override
	public Date getTime() throws RemoteException {
		return new Date();
	}

}
