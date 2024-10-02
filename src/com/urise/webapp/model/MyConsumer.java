package com.urise.webapp.model;

import java.io.IOException;

@FunctionalInterface
public interface MyConsumer<T> {
    void execute(T t) throws IOException;
}

//@FunctionalInterface
//public interface MyConsumer<T> extends Consumer<T> {
//    @Override
//    default void accept(T t) {
//        try {
//            execute(t);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    void execute(T t) throws IOException;
//}

