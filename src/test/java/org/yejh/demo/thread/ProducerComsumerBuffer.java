package org.yejh.demo.thread;

import java.util.ArrayList;
import java.util.List;

public class ProducerComsumerBuffer {
	private static List<Integer> list = new ArrayList<Integer>();
	private static final int CAPACITY = 1;

	public void addElement(int i) {
		synchronized (this) {
			if (list.size() == CAPACITY) {
				System.out.println("[addElement] full, no add");
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			list.add(i);
			System.out.println("[addElement] add: " + i);
			this.notifyAll();
		}
	}

	public void removeElement() {
		synchronized (this) {
			if (list.isEmpty()) {
				System.out.println("[removeElement] empty, no remove");
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			int i = list.remove(0);
			System.out.println("[removeElement] remove: " + i);
			this.notifyAll();
		}
	}
}
