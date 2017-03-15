package org.yejh.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerComsumerTest {
	public static ProducerComsumerBuffer buffer = new ProducerComsumerBuffer();

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.execute(new ProducerRunnable());
		executorService.execute(new ComsumerRunnable());
		executorService.shutdown();
	}

	static class ProducerRunnable implements Runnable {
		int i = 1;

		@Override
		public void run() {
			try {
				while (true) {
					buffer.addElement(i++);
					Thread.sleep((int) Math.random() * 10000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	static class ComsumerRunnable implements Runnable {
		@Override
		public void run() {
			try {
				while (true) {
					buffer.removeElement();
					Thread.sleep((int) Math.random() * 10000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
