package io.grisu.persistentpojo.annotations;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Column {
   boolean primaryKey() default false;
}
