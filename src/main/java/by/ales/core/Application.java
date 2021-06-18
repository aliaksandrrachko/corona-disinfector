package by.ales.core;

import by.ales.core.ApplicationContext;
import by.ales.core.JavaConfig;
import by.ales.core.ObjectFactory;

import java.util.Map;

public class Application {

    public static ApplicationContext run(String packageToScan, Map<Class, Class> ifc2ImplClass) {
        JavaConfig javaConfig = new JavaConfig(packageToScan, ifc2ImplClass);
        ApplicationContext applicationContext = new ApplicationContext(javaConfig);
        ObjectFactory objectFactory = new ObjectFactory(applicationContext);
        // todo homework - init all singleton which are not lazy
        applicationContext.setFactory(objectFactory);
        return applicationContext;
    }
}
