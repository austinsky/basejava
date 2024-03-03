package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.io.ObjectStreamException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
        return doGet(key);
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
    public List<Resume> getAllSorted() {
        return doGetAll().stream().filter(Objects::nonNull).sorted((x, y) -> {
            int result = x.getFullName().compareTo(y.getFullName());
            return (result == 0) ? x.getUuid().compareTo(y.getUuid()) : result;
        }).collect(Collectors.toList());
    }

    protected abstract List<Resume> doGetAll();

    protected abstract void doUpdate(Resume r, T searchKey);

    protected abstract void doSave(Resume r, T searchKey);
    protected abstract Resume doGet(T searchKey);

    protected abstract void doDelete(T searchKey);

    protected abstract T searchKey(String uuid);

    protected abstract boolean isExist(T searchKey);
}
