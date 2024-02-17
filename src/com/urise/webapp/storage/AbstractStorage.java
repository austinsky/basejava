package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {
    @Override
    public void clear() {
        runClear();
    }

    @Override
    public void update(Resume r) {
        Resume resume = searchElement(r.getUuid());
        if (resume != null) {
            runUpdate(r);
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    @Override
    public void save(Resume r) {
        if (isExist(r.getUuid())) {
            throw new ExistStorageException(r.getUuid());
        } else {
            runSave(r);
        }
    }

    @Override
    public Resume get(String uuid) {
        if (isExist(uuid)) {
            return runGet(uuid);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    @Override
    public void delete(String uuid) {
        Resume resume = searchElement(uuid);
        if (resume != null) {
            runDelete(resume);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    protected boolean isExist(String uuid) {
        return (searchElement(uuid) != null);
    }

    @Override
    public abstract Resume[] getAll();

    protected abstract void runClear();

    protected abstract void runUpdate(Resume r);

    protected abstract void runSave(Resume r);
    protected abstract Resume runGet(String uuid);

    protected abstract void runDelete(Resume r);

    protected abstract Resume searchElement(String uuid);

}
