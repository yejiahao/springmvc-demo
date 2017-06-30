package org.yejh.demo.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {
    private FileCopy() {
        throw new AssertionError();
    }

    public static void copyFile(String source, String destination) {
        try {
            InputStream in = new FileInputStream(source);
            OutputStream out = new FileOutputStream(destination);
            int length = 0;
            byte[] buffer = new byte[4096];
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }
            out.flush();
            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String source = "E:/aa/aafile.docx";
        String destination = "E:/a/bbfile.docx";
        System.out.println("-------start--------");
        FileCopy.copyFile(source, destination);
        System.out.println("------- end --------");
    }
}
