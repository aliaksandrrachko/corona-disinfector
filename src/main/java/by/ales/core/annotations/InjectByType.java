package by.ales.core.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Marks a field as to be autowired by dependency injection facilities.
 */
@Target(value = {FIELD})
@Retention(value = RUNTIME)
public @interface InjectByType {
}
