package org.yejh.demo.portscan;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import org.apache.log4j.Logger;

public class PortScanner extends Thread {
	private static final Logger logger = Logger.getLogger(PortScanner.class);

	private String host;
	private int sPort;
	private int ePort;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getsPort() {
		return sPort;
	}

	public void setsPort(int sPort) {
		this.sPort = sPort;
	}

	public int getePort() {
		return ePort;
	}

	public void setePort(int ePort) {
		this.ePort = ePort;
	}

	public PortScanner() {
	}

	public PortScanner(String host, int sPort, int ePort) {
		this.host = host;
		this.sPort = sPort;
		this.ePort = ePort;
	}

	private void scan(String host, int start, int end, Boolean isQuick) {
		Socket socket = null;
		for (int port = start; port < end; port++) {
			try {
				if (isQuick) {
					int timeout = 150;
					socket = new Socket();
					SocketAddress sa = new InetSocketAddress(host, port);
					socket.connect(sa, timeout);
				} else {
					socket = new Socket(host, port);
				}
				logger.info("open port: " + port + " " + socket);
			} catch (Exception e) {
				logger.error("cannot connect to port: " + port);
			} finally {
				if (socket != null) {
					try {
						socket.close();
					} catch (Exception e) {
						logger.error("socket close exception: ", e);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		notThreadPort();
		logger.info("-----------------------------------------------------------------------");
		threadPort();
	}

	private static void notThreadPort() {
		String host = "127.0.0.1";
		int sPort = 110;
		int ePort = 150;
		PortScanner portScanner = new PortScanner();
		long sTime = System.currentTimeMillis();
		portScanner.scan(host, sPort, ePort, Boolean.TRUE);
		long eTime = System.currentTimeMillis();
		logger.info("execute time: " + (eTime - sTime) + " ms");
	}

	private static void threadPort() {
		String host = "127.0.0.1";
		int sPort = 110;
		int ePort = 150;
		int sPort2 = 410;
		int ePort2 = 450;
		Thread portScanner1 = new PortScanner(host, sPort, ePort);
		Thread portScanner2 = new PortScanner(host, sPort2, ePort2);
		portScanner1.start();
		portScanner2.start();
	}

	public void run() {
		scan(host, sPort, ePort, Boolean.TRUE);
	}
}