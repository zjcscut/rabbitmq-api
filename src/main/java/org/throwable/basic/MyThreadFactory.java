package org.throwable.basic;

import java.io.IOException;
import java.util.concurrent.ThreadFactory;

/**
 * @author zhangjinci
 * @version 2017/1/17 16:10
 * @function
 */
public class MyThreadFactory implements ThreadFactory {

    final String prefix = "demo-thread-";
    int count = 1;
    @Override
    public Thread newThread(Runnable r) {
        return new Thread(prefix + count++);
    }

    public static void main(String[] args) throws IOException {
         MyThreadFactory factory = new MyThreadFactory();
         Task task = new Task();
         Thread t1 = factory.newThread(task);
         Thread t2 = factory.newThread(task);
         t1.start();
         t2.start();
        System.out.printf("Main: Thread information.\n");
        System.out.printf("%s\n",t1);
        System.out.printf("%s\n",t2);
        System.out.printf("Main: End of the example.\n");

        System.in.read();
    }
}
