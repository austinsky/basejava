package com.urise.webapp;

// Реализация классического deadlock
public class MainDeadLock {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        new Thread(() -> {
            work(lock1, lock2, "1 поток");
        }).start();

        new Thread(() -> {
            work(lock2, lock1, "2 поток");
        }).start();
    }

    public static void work(Object obj1, Object obj2, String name) {
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
