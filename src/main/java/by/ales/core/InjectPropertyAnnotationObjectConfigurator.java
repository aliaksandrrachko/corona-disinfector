package by.ales.core;

import by.ales.core.intefaces.ObjectConfigurator;
import by.ales.core.annotations.InjectProperty;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InjectPropertyAnnotationObjectConfigurator implements ObjectConfigurator {

    private final Map<String, String> propertiesMap;

    @SneakyThrows
    public InjectPropertyAnnotationObjectConfigurator() {
        String path = ClassLoader.getSystemClassLoader().getResource("application.properties").getPath();
        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            Stream<String> lines = bf.lines();
            this.propertiesMap = lines
                    .map(line -> line.trim().split("="))
                    .collect(Collectors.toMap(arr -> arr[0], arr -> arr[1]));
        }
    }

    @SneakyThrows
    @Override
    public void configure(Object t, ApplicationContext context) {
        Class<?>  implClass = t.getClass();
        for (Field field : implClass.getDeclaredFields()) {
            InjectProperty annotation = field.getAnnotation(InjectProperty.class);
            if (annotation != null){
                String value = annotation.value().isEmpty() ?  propertiesMap.get(field.getName()) : propertiesMap.get(annotation.value());
                field.setAccessible(true);
                field.set(t, value);
            }
        }
    }
}
