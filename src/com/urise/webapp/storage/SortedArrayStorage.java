package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    public void save(Resume r) {
        int index = getIndex(r.getUuid());

        if (index < 0) {
            // this is a new value to insert (not a duplicate).
            index = - index - 1;
        }
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = r;
        size++;
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);

        if (isExist(index)) {
            int countElementsToCopy = size - index - 1;
            System.arraycopy(storage, index + 1, storage, index, countElementsToCopy);
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Резюме с uuid " + uuid + " не найдено. Удаление не произведено");
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
