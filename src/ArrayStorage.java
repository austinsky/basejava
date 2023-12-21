/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private static final int CAPACITY_STORAGE = 10000;

    Resume[] storage = new Resume[CAPACITY_STORAGE];

    private int size = 0;

    void clear() {
        size = 0;
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        if (size < CAPACITY_STORAGE) {
            storage[size++] = r;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(uuid)) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] result = new Resume[size];
        for (int i = 0; i < size; i++) {
            result[i] = storage[i];
        }
        return result;
    }

    int size() {
        return size;
    }
}
