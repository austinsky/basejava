package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.NoSuchElementException;

public class MapResumeStorage extends AbstractMapStorage<Resume> {
    @Override
    protected Resume searchKey(String uuid) {
//        try {
//            return storage.values()
//                    .stream()
//                    .filter(x -> x.getUuid().equals(uuid))
//                    .findFirst().get();
//        } catch (NoSuchElementException e) {
//            return null;
//        }
        return storage.get(uuid);
    }

    @Override
    protected boolean isExist(Resume searchKey) {
        return storage.containsValue(searchKey);
    }

    @Override
    public void doSave(Resume r, Resume key) {
            storage.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(Resume searchKey) {
        return searchKey;
    }

    @Override
    protected void doDelete(Resume searchKey) {
        if (searchKey != null) {
            storage.remove(searchKey.getUuid());
        }
    }

    @Override
    public void doUpdate(Resume r, Resume key) {
        if (key != null) {
            storage.put(key.getUuid(), r);
        }
    }
}
