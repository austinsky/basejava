package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final int STORAGE_LIMIT = 10000;

    protected int size = 0;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    public int size() {
        return size;
    }

    public void runClear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected final void runSave(Resume r) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Переполнение Storage.", r.getUuid());
        }  else {
            insertResume(r);
            size++;
        }
    }

    protected final void runDelete(Resume r) {
        int index = getIndex(r.getUuid());

        if (isExist(index)) {
            fillRemovedResume(index);
            storage[size - 1] = null;
            size--;
        } else {
            throw new NotExistStorageException(r.getUuid());
        }
    }

    protected final void runUpdate(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (isExist(index)) {
            storage[index] = resume;
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    protected final Resume runGet(String uuid) {
        int index = getIndex(uuid);
        if (!isExist(index)) {
            throw new NotExistStorageException(uuid);
        }

        return storage[index];
    }

    protected boolean isExist(int index) {
        return index >= 0;
    }

    public Resume searchElement(String uuid) {
        int index = getIndex(uuid);
        if (!isExist(index)) {
            return null;
        }

        return storage[index];
    }

    protected abstract int getIndex(String uuid);

    public abstract void fillRemovedResume(int index);

    public abstract void insertResume(Resume r);


}
