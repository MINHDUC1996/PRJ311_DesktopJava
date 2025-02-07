/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author duclt
 */
public class Yield {

    public static void main(String[] args) {
        new ThreadDemo("Thread 1");
        new ThreadDemo("Thread 2");
        new ThreadDemo("Thread 3");
    }

}

class ThreadDemo implements Runnable {

    Thread t;

    ThreadDemo(String str) {

        t = new Thread(this, str);
        // this will call run() function
        t.start();
    }

    public void run() {

        for (int i = 0; i < 5; i++) {
            // yields control to another thread every 5 iterations
            if ((i % 5) == 0) {
                System.out.println(Thread.currentThread().getName() + "yielding control...");

                /* causes the currently executing thread object to temporarily 
   pause and allow other threads to execute */
                Thread.yield();
            }
        }

        System.out.println(Thread.currentThread().getName() + " has finished executing.");
    }
}
