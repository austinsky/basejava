

package com.urise.webapp.storage;

        import com.urise.webapp.exception.NotExistStorageException;
        import com.urise.webapp.model.Resume;
        import com.urise.webapp.exception.*;
        import org.junit.Assert;
        import org.junit.Before;
        import org.junit.Test;

        import static org.junit.Assert.*;

public abstract class AbstractStorageTest {

    protected final Storage storage;
    public static final String UUID_1 = "uuid1";
    public static final String UUID_2 = "uuid2";
    public static final String UUID_3 = "uuid3";

    public static final String UUID_TEST = "uuid0";

    public static final String UUID_NOT_EXISTS = "dummy";

    public static final Resume RESUME_1 = new Resume();
    public static final Resume RESUME_2 = new Resume();
    public static final Resume RESUME_3 = new Resume();

    public static final Resume RESUME_TEST = new Resume();

    static {
        RESUME_1.setUuid(UUID_1);
        RESUME_2.setUuid(UUID_2);
        RESUME_3.setUuid(UUID_3);
        RESUME_TEST.setUuid(UUID_TEST);
    }

    public AbstractStorageTest(Storage storage) {
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
        assertSize(3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
        Resume[] resumes = storage.getAll();
        Assert.assertArrayEquals(new Resume[0], resumes);
    }

    @Test
    public void getAll() {
        Resume[] arrayResume = storage.getAll();
        Assert.assertArrayEquals(new Resume[] {
                RESUME_1, RESUME_2, RESUME_3
        }, arrayResume);
    }

    @Test
    public void save() {
        storage.save(RESUME_TEST);
        assertSize(4);
        assertGet(RESUME_TEST);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExistElement()  {
        storage.save(RESUME_1);
        Assert.assertEquals(3, storage.size());
    }


    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_3);
        assertSize(2);
        storage.get(UUID_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExistElement() {
        storage.delete(UUID_NOT_EXISTS);
    }

    @Test
    public void update() {
        Resume newResume = new Resume();
        newResume.setUuid(UUID_2);
        storage.update(newResume);
        assertSame(newResume, storage.get(UUID_2));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.get(UUID_NOT_EXISTS);
    }

    @Test
    public void get() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExistElement() {
        storage.get(UUID_NOT_EXISTS);
    }

    protected void assertSize(int size) {
        Assert.assertEquals(size, storage.size());
    }

    protected void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }
}