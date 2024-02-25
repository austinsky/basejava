package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {

    protected static final int STORAGE_LIMIT = 10000;

    protected int size = 0;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public List<Resume> getAllSorted() {
        return Arrays.stream(storage).filter(x -> x != null).sorted((x, y) -> {
            int result = x.getFullName().compareTo(y.getFullName());
            return (result == 0) ? x.getUuid().compareTo(y.getUuid()) : result;
        }).collect(Collectors.toList());
    }

    protected final void doSave(Resume r, Integer key) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Переполнение Storage.", r.getUuid());
        }  else {
            insertResume(r);
            size++;
        }
    }

    protected final void doDelete(Integer key) {
        fillRemovedResume(key);
        storage[size - 1] = null;
        size--;
    }

    protected final void doUpdate(Resume resume, Integer key) {
        storage[key] = resume;
    }

    protected final Resume doGet(Integer key) {
        return storage[key];
    }

    protected boolean isExist(Integer key) {
        return ((key != null) && (key.intValue() >= 0));
    }

    public Integer searchKey(String uuid) {
        int index = getIndex(uuid);
        if (!isExist(index)) {
            return null;
        }

        return index;
    }

    protected abstract int getIndex(String uuid);

    public abstract void fillRemovedResume(int index);

    public abstract void insertResume(Resume r);
}
