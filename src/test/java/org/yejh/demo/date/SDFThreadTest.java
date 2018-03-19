package org.yejh.demo.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Ye Jiahao on 2018/03/04.
 */
public class SDFThreadTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new MyThread().start();
        }
    }

    /**
     * SimpleDateFormat线程不安全解决方法：
     * 1. SimpleDateFormat设置为局部变量
     * 2. synchronized块
     * 3. 第三方时间类库（joda-time）
     * 4. JDK8时间类库
     * 5. ThreadLocal<T>线程局部变量
     */
    static class MyThread extends Thread {
        @Override
        public void run() {
            try {
                DateFormat df = OldDate.getDf();
                DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                DateFormat df5 = OldDate.local.get();
                System.out.println(Thread.currentThread().getName() + "\t" + df.parse("2018-03-20 00:15:30"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
