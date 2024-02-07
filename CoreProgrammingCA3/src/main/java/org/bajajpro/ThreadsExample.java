package org.bajajpro;

public class ThreadsExample {
    public static ThreadsExample output = new ThreadsExample ();
    private final Object toSync = new Object ();
    private int state = 0;

    public void print (char pChar) {
        synchronized (toSync) {
            while (true) {
                if (state == 0) {
                    System.out.print(pChar + ",");
                    state = 1;
                    toSync.notify();
                    return;
                } else {
                    try {
                        toSync.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }

    public void print (int pInt) {
        synchronized (toSync) {
            while (true) {
                if (state == 1) {
                    System.out.print(pInt + "\n");
                    state = 0;
                    toSync.notify();
                    return;
                } else {
                    try {
                        toSync.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}

class Runnable2 implements Runnable{
    public void run(){
        for(char i='A';i<='E';i++) {
            ThreadsExample.output.print(i);
        }
    }
}

class Runnable1 implements Runnable{
    public void run(){
        for(int i=1;i<=5;i++) {
            ThreadsExample.output.print(i);
        }
    }
}

