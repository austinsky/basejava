package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
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

    public final void save(Resume r) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Переполнение Storage.", r.getUuid());
        } else if (isExist(getIndex(r.getUuid()))) {
            throw new ExistStorageException(r.getUuid());
        } else {
            insertResume(r);
            size++;
        }
    }

    public final void delete(String uuid) {
        int index = getIndex(uuid);

        if (isExist(index)) {
            fillRemovedResume(index);
            storage[size - 1] = null;
            size--;
        } else {
            throw new NotExistStorageException(uuid);

        }
    }

    public final void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (isExist(index)) {
            storage[index] = resume;
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    public final Resume get(String uuid) {
        int index = getIndex(uuid);
        if (!isExist(index)) {
            throw new NotExistStorageException(uuid);
        }

        return storage[index];
    }

    protected boolean isExist(int index) {
        return index >= 0;
    }

    protected abstract int getIndex(String uuid);

    public abstract void fillRemovedResume(int index);

    public abstract void insertResume(Resume r);
}
