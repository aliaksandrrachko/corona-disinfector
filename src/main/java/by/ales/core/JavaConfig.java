package by.ales.core;

import by.ales.core.intefaces.Config;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class JavaConfig implements Config {

    private final Reflections scanner;

    /**
     * Map of interface - implements class
     */
    private Map<Class, Class> ifc2ImplClass;

    public JavaConfig(String packageToScan, Map<Class, Class> ifc2ImplClass) {
        this.scanner = new Reflections(packageToScan);
        this.ifc2ImplClass = ifc2ImplClass;
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> ifc) {
        return ifc2ImplClass.computeIfAbsent(ifc, aClass -> {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc);
        if (classes.size() != 1) {
            throw new IllegalArgumentException(ifc + "has 0 or than one impl please update your config");
        }
        return classes.iterator().next();
      });
    }

    @Override
    public Reflections getScanner() {
        return this.scanner;
    }
}
