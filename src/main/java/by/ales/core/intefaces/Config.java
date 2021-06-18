package by.ales.core.intefaces;

import org.reflections.Reflections;

public interface Config {

    /**
     * Searching and returns the class implementing giving interface
     * @param ifc interface
     * @param <T> type of interface
     * @return the class implementing giving interface
     */
    <T> Class<? extends T> getImplClass(Class<T> ifc);

    /**
     * Returns configuring scanner
     * @return the scanner
     */
    Reflections getScanner();
}
