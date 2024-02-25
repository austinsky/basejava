package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class MapFullNameStorage extends AbstractMapStorage {
    @Override
    protected String searchKey(String uuid) {
        try {
            return storage.values()
                    .stream().filter(x -> x.getUuid().equals(uuid)).map(x -> x.getFullName()).findFirst().get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override
    public void doSave(Resume r, String key) {
        storage.put(r.getFullName(), r);
    }
}
