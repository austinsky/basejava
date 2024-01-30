package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;


/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public void save(Resume r) {
        if (size >= STORAGE_LIMIT) {
            System.out.println("Переполнение Storage.");
        } else if (isExist(getIndex(r.getUuid()))) {
            System.out.println("Резюме существует. Добавление не выполнено");
        } else {
            insert(r);
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);

        if (isExist(index)) {
            remove(index);
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Резюме с uuid " + uuid + " не найдено. Удаление не произведено");
        }
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (isExist(index)) {
            storage[index] = resume;
        } else {
            System.out.println("Резюме с uuid " + resume.getUuid() + " не найдено. Нечего обновлять");
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (isExist(index)) {
            return storage[index];
        } else {
            System.out.println("Резюме с uuid " + uuid + " не найдено");
        }

        return null;
    }

    protected boolean isExist(int index) {
        return index >= 0;
    }

    protected abstract int getIndex(String uuid);

    public abstract void remove(int index);

    public abstract void insert(Resume r);
}
