package com.urise.webapp.storage.serializator;

import java.io.IOException;

@FunctionalInterface
public interface MyConsumer<T> {
    void execute(T t) throws IOException;
}