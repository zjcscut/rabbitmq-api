package org.throwable.basic;

/**
 * @author zhangjinci
 * @version 2017/1/17 16:11
 * @function
 */
public class Task implements Runnable {

    @Override
    public void run() {
        System.out.println("task在执行");
    }
}
