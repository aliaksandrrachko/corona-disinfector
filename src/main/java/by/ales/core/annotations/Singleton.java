package by.ales.core.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Scopes a single bean definition to a single object instance per IoC container.
 */
@Target(value = {TYPE})
@Retention(value = RUNTIME)
public @interface Singleton {
}
