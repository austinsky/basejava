package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.io.ObjectStreamException;

public abstract class AbstractStorage<T> implements Storage {

    @Override
    public void update(Resume r) {
        T key = getExistingSearchKey(r.getUuid());
        doUpdate(r, key);
    }

    @Override
    public void save(Resume r) {
        T key = getNotExistingSearchKey(r.getUuid());
        doSave(r, key);
    }

    @Override
    public Resume get(String uuid) {
        T key = getExistingSearchKey(uuid);
        return doGet(uuid, key);
    }

    @Override
    public void delete(String uuid) {
        T key = getExistingSearchKey(uuid);
        doDelete(key);
    }

    protected T getExistingSearchKey(String uuid) {
        T key = searchKey(uuid);
        if (!isExist(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    protected T getNotExistingSearchKey(String uuid) {
        T key = searchKey(uuid);
        if (isExist(key)) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    @Override
    public abstract Resume[] getAll();

    protected abstract void doUpdate(Resume r, T searchKey);

    protected abstract void doSave(Resume r, T searchKey);
    protected abstract Resume doGet(String uuid, T searchKey);

    protected abstract void doDelete(T searchKey);

    protected abstract T searchKey(String uuid);

    protected abstract boolean isExist(T searchKey);
}
