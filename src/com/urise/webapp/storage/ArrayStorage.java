package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private static final int CAPACITY_STORAGE = 10000;

    Resume[] storage = new Resume[CAPACITY_STORAGE];

    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        if (!isExistsResume(r)) {
            if (size < CAPACITY_STORAGE) {
                storage[size++] = r;
            } else {
                System.out.println("Переполнение Storage.");
            }
        } else {
            System.out.println("Резюме существует. Добавление не выполнено");
        }
    }

    public void update(Resume resume) {
        if (isExistsResume(resume)) {
            int index = getIndexResumeStorage(resume.getUuid());
            storage[index] = resume;
        } else {
            System.out.println("Резюме с uuid " + resume.getUuid() + " не найдено. Нечего обновлять");
        }
    }

    public Resume get(String uuid) {
        int index = getIndexResumeStorage(uuid);
        if (index != -1) {
            return storage[index];
        } else {
            System.out.println("Резюме с uuid " + uuid + " не найдено");
        }

        return null;
    }

    public void delete(String uuid) {
        int index = getIndexResumeStorage(uuid);
        if (index != -1) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Резюме с uuid " + uuid + " не найдено. Удаление не произведено");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] result = Arrays.copyOf(storage, size);
        return result;
    }

    public int size() {
        return size;
    }

    private boolean isExistsResume(Resume r) {
        return (getIndexResumeStorage(r.getUuid()) != -1) ? true : false;
    }

    private int getIndexResumeStorage(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }

        return -1;
    }
}
