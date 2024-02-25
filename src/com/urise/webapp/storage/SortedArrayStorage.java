package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    public void insertResume(Resume r) {
        int index = getIndex(r.getUuid());

        if (index < 0) {
            // this is a new value to insert (not a duplicate).
            index = - index - 1;
        }
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = r;
    }

    public void fillRemovedResume(int index) {
        int countElementsToCopy = size - index - 1;
        System.arraycopy(storage, index + 1, storage, index, countElementsToCopy);
    }

    @Override
    protected int getIndex(String uuid) {
        return Arrays.binarySearch(Arrays.stream(storage).filter(x -> x != null)
                .map(x -> x.getUuid()).toArray(), 0, size, uuid);
    }
}