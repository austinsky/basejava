package com.urise.webapp.storage;

import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import com.urise.webapp.exception.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {

    private Storage storage;
    public static final String UUID_1 = "uuid1";
    public static final String UUID_2 = "uuid2";
    public static final String UUID_3 = "uuid3";

    public static final Resume RESUME_1 = new Resume();
    public static final Resume RESUME_2 = new Resume();
    public static final Resume RESUME_3 = new Resume();

    static {
        RESUME_1.setUuid(UUID_1);
        RESUME_2.setUuid(UUID_2);
        RESUME_3.setUuid(UUID_3);
    }

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void getAll() {
        Resume[] arrayResume = storage.getAll();
        Assert.assertEquals(3, arrayResume.length);
        Assert.assertEquals(RESUME_1, arrayResume[0]);
        Assert.assertEquals(RESUME_2, arrayResume[1]);
        Assert.assertEquals(RESUME_3, arrayResume[2]);
    }

    @Test
    public void save() {
        Resume testResume = new Resume();
        testResume.setUuid("UUID_0");
        storage.save(testResume);
        Assert.assertEquals(4, storage.size());
        Assert.assertEquals(testResume, storage.get(testResume.getUuid()));
    }

    @Test(expected = ExistStorageException.class)
    public void saveExistElement() throws Exception {
        storage.save(RESUME_1);
        Assert.assertEquals(3, storage.size());
    }

    @Test(expected = StorageException.class)
    public void saveStorageOverflow() throws Exception {

        // Заполняем до
        try {
            for (int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT - 3; i++) {
                Resume r = new Resume();
                r.setUuid("uuid_1" + i);
                storage.save(r);
            }
        } catch (StorageException e) {
            Assert.fail();
        }

        // заполняем через край
        storage.save(new Resume());
    }



    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_3);
        assertEquals(2, storage.size());
        storage.get(UUID_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExistElement() {
        storage.delete("MyTest");
    }

    @Test
    public void update() {
        Resume newResume = new Resume();
        newResume.setUuid(UUID_2);
        storage.update(newResume);
        assertSame(newResume, storage.get(UUID_2));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test
    public void get() {
        assertEquals(RESUME_1, storage.get(RESUME_1.getUuid()));
        assertEquals(RESUME_2, storage.get(RESUME_2.getUuid()));
        assertEquals(RESUME_3, storage.get(RESUME_3.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExistElement() {
        storage.get("object not found");
    }
}