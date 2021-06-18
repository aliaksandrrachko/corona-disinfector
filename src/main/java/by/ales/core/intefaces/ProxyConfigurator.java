package by.ales.core.intefaces;

public interface
ProxyConfigurator {

    /**
     * Replace object in context to proxy if needing
     * @param t the original object
     * @param implClass the implements class
     * @param <T> type of class
     * @return the proxy of object {@code t} if needing
     */
    <T> Object replaceWithProxyIfNeeded(Object t, Class<T> implClass);
}