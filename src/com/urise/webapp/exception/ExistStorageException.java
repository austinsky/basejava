package com.urise.webapp.exception;

public class ExistStorageException extends StorageException {
    public ExistStorageException(String uuid) {
//        System.out.println("Резюме существует. Добавление не выполнено");
        super("Resume " + uuid + " already exist", uuid);
    }
}
