package by.ales.core.intefaces;

import by.ales.core.ApplicationContext;

/**
 * This class is analogue Spring's BeanPostProcessor
 */
public interface ObjectConfigurator {

    /**
     * Configures object
     * @param t object for configuration
     * @param context the application context
     */
    void configure(Object t, ApplicationContext context);
}
