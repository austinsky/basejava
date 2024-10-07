package com.urise.webapp.storage.serializator;

import java.io.IOException;

@FunctionalInterface
public interface MyWriter<T> {
    void execute(T t) throws IOException;
}