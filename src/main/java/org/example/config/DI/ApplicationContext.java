package org.example.config.DI;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ApplicationContext {
    private final Map<Class<?>, Object> beanMap = new HashMap<>();

    public ApplicationContext(String basePackage){
        Set<Class<?>> components = ClassScanner.scanForComponents(basePackage);
        for(Class<?> clazz : components){
            createBean(clazz);
        }
    }

    private Object createBean(Class<?> clazz) {
        if(beanMap.containsKey(clazz)){
            return beanMap.get(clazz);
        }
        try {
            Constructor<?> constructor = Arrays.stream(clazz.getDeclaredConstructors())
                    .filter(c -> c.isAnnotationPresent(Autowired.class))
                    .findFirst()
                    .orElse(clazz.getDeclaredConstructor());

            Class<?>[] paramTypes = constructor.getParameterTypes();
            Object[] params = new Object[paramTypes.length];

            for(int i=0; i< paramTypes.length; i++){
                params[i] = createBean(paramTypes[i]);
            }
            Object instance = constructor.newInstance(params);
            beanMap.put(clazz, instance);
            return instance;
        } catch (Exception e){
            throw new RuntimeException("failed to create bean" + clazz.getName());
        }
    }

}
