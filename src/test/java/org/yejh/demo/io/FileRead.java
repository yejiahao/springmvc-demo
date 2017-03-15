package org.yejh.demo.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileRead {
	public static void main(String[] args) {
		String fileName = "C:/Users/Administrator/Desktop/work.txt";
		BufferedReader bf = null;
		try {
			// bf = new BufferedReader(new FileReader(fileName));
			bf = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "GBK"));
			String lineMessage = null;
			while ((lineMessage = bf.readLine()) != null) {
				System.out.println(lineMessage);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bf != null) {
					bf.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
