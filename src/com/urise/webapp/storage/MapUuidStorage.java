package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapUuidStorage extends AbstractMapStorage {
    @Override
    protected String searchKey(String uuid) {
        return uuid;
    }

    @Override
    public void doSave(Resume r, String key) {
        storage.put(r.getUuid(), r);
    }

    @Override
    public Resume doGet(String key) {
        return storage.get(key);
    }
}
