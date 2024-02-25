package com.urise.webapp;

import com.urise.webapp.model.Resume;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume r = new Resume("lex");
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r, "new_uuid");
        System.out.println(field.get(r));
        field.setAccessible(false);

        // TODO : invoke r.toString via reflection
        Method toStringMethod = r.getClass().getMethod("toString");
        System.out.println(toStringMethod.invoke(r));

        System.out.println(r);
    }
}
