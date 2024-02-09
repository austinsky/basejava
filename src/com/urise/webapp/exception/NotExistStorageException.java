package com.urise.webapp.exception;

public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String uuid) {
        // System.out.println("Резюме с uuid " + resume.getUuid() + " не найдено. Нечего обновлять");
        //            System.out.println("Резюме с uuid " + uuid + " не найдено. Удаление не произведено");
        super("Resume " + uuid + " not exist", uuid);
    }
}
