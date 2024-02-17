package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ListStorage extends AbstractStorage {

    protected List<Resume> storage = new ArrayList<>();


    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[storage.size()]);
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
        int index = storage.indexOf(r);
        storage.set(index, r);
    }

    @Override
    public void runSave(Resume r) {
        storage.add(r);
    }

    @Override
    public Resume runGet(String uuid) {
        return searchElement(uuid);
    }

    @Override
    public void runDelete(Resume r) {
        storage.remove(r);
    }

    @Override
    public Resume searchElement(String uuid) {
       Resume resume;

       try {
           resume = storage.stream().filter(x -> x.getUuid() == uuid).findFirst().get();
       } catch (NoSuchElementException e) {
           resume = null;
       }

       return resume;
    }
}
