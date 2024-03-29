package com.urise.webapp;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.AbstractArrayStorage;
import com.urise.webapp.storage.ArrayStorage;
import com.urise.webapp.storage.SortedArrayStorage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Interactive test for ArrayStorage implementation
 * (just run, no need to understand)
 */
public class MainArray {
//       private final static AbstractArrayStorage ARRAY_STORAGE = new ArrayStorage();
    private final static AbstractArrayStorage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Resume r;
        while (true) {
            System.out.print("Введите одну из команд - (list | size | save name | delete uuid | get uuid | clear | exit): ");
            String[] params = reader.readLine().trim().toLowerCase().split(" ");
            if (params.length < 1 || params.length > 2) {
                System.out.println("Неверная команда.");
                continue;
            }
            String name = null;
            if (params.length == 2) {
                name = params[1].intern();
            }
            try {
                switch (params[0]) {
                    case "list":
                        printAll();
                        break;
                    case "size":
                        System.out.println(ARRAY_STORAGE.size());
                        break;
                    case "save":
                        r = new Resume(name);
                        ARRAY_STORAGE.save(r);
                        printAll();
                        break;
                    case "delete":
                        ARRAY_STORAGE.delete(name);
                        printAll();
                        break;
                    case "get":
                        System.out.println(ARRAY_STORAGE.get(name));
                        break;
                    case "clear":
                        ARRAY_STORAGE.clear();
                        printAll();
                        break;
                    case "exit":
                        return;
                    default:
                        System.out.println("Неверная команда.");
                        break;
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void printAll() {
        List<Resume> all = ARRAY_STORAGE.getAllSorted();
        System.out.println("----------------------------");
        if (all.size() == 0) {
            System.out.println("Empty");
        } else {
            for (Resume r : all) {
                System.out.println(r);
            }
        }
        System.out.println("----------------------------");
    }
}
