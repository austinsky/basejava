package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ListStorage extends AbstractStorage<Integer> {

    protected List<Resume> storage = new ArrayList<>();

    @Override
    public List<Resume> doGetAll() {
        return storage.stream().toList();
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
    public Resume doGet(Integer key) {
        return storage.get(key);
    }

    @Override
    public void doDelete(Integer key) {
        storage.remove(key.intValue());
    }

    @Override
    public Integer searchKey(String uuid) {
        for (int i = 0; i < storage.size(); ++i) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey != null;
    }
}
