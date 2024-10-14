package com.urise.webapp;

// Реализация классического deadlock
public class MainDeadLock {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        startThread(lock1, lock2, "1 поток");
        startThread(lock2, lock1, "2 поток");
    }

    private static void startThread(Object lock1, Object lock2, String threadName) {
        new Thread(() -> work(lock1, lock2, threadName)).start();
    }

    private static void work(Object obj1, Object obj2, String name) {
        synchronized (obj1) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (obj2) {
                System.out.println("Управление у " + name);
            }
        }
    }
}
