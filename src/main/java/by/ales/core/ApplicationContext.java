package by.ales.core;

import by.ales.core.intefaces.Config;
import by.ales.core.annotations.Singleton;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {

    @Setter
    private ObjectFactory factory;
    private final Map<Class<?>, Object> cache = new ConcurrentHashMap<>();
    private final Config config;

    public ApplicationContext(Config config) {
        this.config = config;
    }

    public <T> T getObject(Class<T> type){
        Class<? extends T> implClass = type;
        if (this.cache.containsKey(type)){
            return (T) this.cache.get(type);
        }

        if (type.isInterface()){
            implClass = this.config.getImplClass(type);
        }

        T t = this.factory.createObject(implClass);

        if (implClass.isAnnotationPresent(Singleton.class)){
            this.cache.put(type, t);
        }

        return t;
    }

    public Config getConfig() {
        return this.config;
    }
}
