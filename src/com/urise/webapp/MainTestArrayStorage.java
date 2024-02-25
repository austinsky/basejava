package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.*;

/**
 * Test for your ArrayStorage implementation
 */
public class MainTestArrayStorage {
//    static final AbstractArrayStorage ARRAY_STORAGE = new ArrayStorage();
//    static final AbstractArrayStorage ARRAY_STORAGE = new SortedArrayStorage();
static final AbstractStorage<String> ARRAY_STORAGE = new MapFullNameStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume("name_uuid1");
        Resume r2 = new Resume("name_uuid2");
        Resume r3 = new Resume("name_uuid3");

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        try {
            System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
        System.out.println("\nTest update");
        printAll();
        ARRAY_STORAGE.update(r3);
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());


        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);
        printAll();
        ARRAY_STORAGE.update(r3);
        printAll();
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }
}
