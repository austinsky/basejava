package com.urise.webapp.storage.serializator;

import java.io.IOException;

@FunctionalInterface
public interface MyReader {
    void execute() throws IOException;
}