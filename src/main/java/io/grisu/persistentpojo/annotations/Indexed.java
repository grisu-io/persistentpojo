package io.grisu.persistentpojo.annotations;

import java.lang.annotation.*;

import io.grisu.persistentpojo.Index;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Indexed {
   Index.IndexType type() default Index.IndexType.DEFAULT;
}
