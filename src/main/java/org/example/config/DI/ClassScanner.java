package org.example.config.DI;

import org.reflections.Reflections;

import java.util.Set;

public class ClassScanner {

    public static Set<Class<?>> scanForComponents(String basePackage){
        Reflections reflections = new Reflections(basePackage);
        return  reflections.getTypesAnnotatedWith(Component.class);
    }
}
