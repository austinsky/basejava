package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;
import java.util.stream.Collectors;

public abstract class AbstractMapStorage extends AbstractStorage<String> {

    protected Map<String, Resume> storage = new HashMap<>();

    @Override
    public List<Resume> getAllSorted() {
        return storage.values().stream().filter(x -> x != null).sorted((x, y) -> {
            int result = x.getFullName().compareTo(y.getFullName());
            return (result == 0) ? x.getUuid().compareTo(y.getUuid()) : result;
        }).collect(Collectors.toList());
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public void doUpdate(Resume r, String key) {
        storage.put(key, r);
    }

    @Override
    public abstract void doSave(Resume r, String key);

    @Override
    public Resume doGet(String key) {
        return storage.get(key);
    }

    @Override
    public void doDelete(String key) {
        storage.remove(key);
    }

    @Override
    protected abstract String searchKey(String uuid);

    @Override
    protected boolean isExist(String searchKey) {
        return storage.containsKey(searchKey);
    }
}
