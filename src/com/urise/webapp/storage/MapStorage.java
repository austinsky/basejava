package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {

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
    public void runClear() {
        storage.clear();
    }

    @Override
    public void runUpdate(Resume r) {
        storage.put(r.getUuid(), r);
    }

    @Override
    public void runSave(Resume r) {
        storage.put(r.getUuid(), r);
    }

    @Override
    public Resume runGet(String uuid) {
        return searchElement(uuid);
    }

    @Override
    public void runDelete(Resume r) {
        storage.remove(r.getUuid());
    }

    @Override
    protected Resume searchElement(String uuid) {
        return (storage.containsKey(uuid)) ? storage.get(uuid) : null;
    }
}
