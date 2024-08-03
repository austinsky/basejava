package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapUuidStorage extends AbstractMapStorage<String> {
    @Override
    protected String searchKey(String uuid) {
        return uuid;
    }

    @Override
    public void doSave(Resume r, String key) {
        storage.put(r.getUuid(), r);
    }

    @Override
    public void doUpdate(Resume r, String key) {
        storage.put(key, r);
    }

    @Override
    public Resume doGet(String key) {
        return storage.get(key);
    }

    @Override
    public void doDelete(String key) {
        storage.remove(key);
    }

    @Override
    protected boolean isExist(String searchKey) {
        return storage.containsKey(searchKey);
    }
}
