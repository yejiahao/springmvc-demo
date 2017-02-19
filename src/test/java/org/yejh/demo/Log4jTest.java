package org.yejh.demo;

import org.apache.log4j.Logger;

public class Log4jTest {
	private static final Logger log = Logger.getLogger(Log4jTest.class);

	public void method1() {
		log.info("start method1...");
	}

	public static void main(String[] args) {
		log.error("start main...");
		new Log4jTest().method1();
		log.error("end main...");
	}
}
