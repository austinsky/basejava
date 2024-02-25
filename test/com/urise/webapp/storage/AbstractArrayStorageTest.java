package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class AbstractArrayStorageTest extends AbstractStorageTest {
    public AbstractArrayStorageTest() {
        super(new ArrayStorage());
    }

    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveStorageOverflow() {

        // очищаем
        storage.clear();
        assertSize(0);

        // Заполняем до
        try {
            for (int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                Resume r = new Resume("uuid_" + i, "name_" + i);
                storage.save(r);
            }
        } catch (StorageException e) {
            Assert.fail();
        }

        // заполняем через край. Должен вызвать StorageException
        storage.save(RESUME_TEST);
    }
}