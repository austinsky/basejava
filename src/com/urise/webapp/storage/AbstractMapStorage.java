package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;
import java.util.stream.Collectors;

public abstract class AbstractMapStorage<T> extends AbstractStorage<T> {

    protected Map<String, Resume> storage = new HashMap<>();

    @Override
    public List<Resume> doGetAll() {
        return storage.values().stream().toList();
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public void clear() {
        storage.clear();
    }

}
