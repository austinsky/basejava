package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage<String> {

    protected Map<String, Resume> storage = new HashMap<>();


    @Override
    public Resume[] getAll() {
        Resume[] resumes = storage.values().toArray(new Resume[storage.size()]);
        Arrays.sort(resumes);
        return resumes;
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
    public void doSave(Resume r, String key) {
        storage.put(r.getUuid(), r);
    }

    @Override
    public Resume doGet(String uuid, String key) {
        return storage.get(key);
    }

    @Override
    public void doDelete(String key) {
        storage.remove(key);
    }

    @Override
    protected String searchKey(String uuid) {
        return (storage.containsKey(uuid)) ? uuid : null;
    }

    @Override
    protected boolean isExist(String searchKey) {
        return searchKey != null;
    }
}
