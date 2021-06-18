package by.ales.core.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * The PostConstruct annotation is used on a method that needs to be executed
 * after dependency injection.
 */
@Documented
@Target(value = {METHOD})
@Retention(value = RUNTIME)
public @interface PostConstruct {
}
