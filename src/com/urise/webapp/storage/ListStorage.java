package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ListStorage extends AbstractStorage<Integer> {

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
    public void clear() {
        storage.clear();
    }

    @Override
    public void doUpdate(Resume r, Integer key) {
        storage.set(key, r);
    }

    @Override
    public void doSave(Resume r, Integer key) {
        storage.add(r);
    }

    @Override
    public Resume doGet(String uuid, Integer key) {
        return storage.get(key);
    }

    @Override
    public void doDelete(Integer key) {
        storage.remove(key.intValue());
    }

    @Override
    public Integer searchKey(String uuid) {
       try {
           Resume resume = storage.stream().filter(x -> x.getUuid() == uuid).findFirst().get();
           return storage.indexOf(resume);
       } catch (NoSuchElementException e) {
           return null;
       }
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey != null;
    }
}
