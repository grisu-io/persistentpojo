package io.grisu.persistentpojo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import io.grisu.persistentpojo.annotations.Column;
import io.grisu.persistentpojo.annotations.Entity;
import io.grisu.persistentpojo.annotations.Indexed;
import io.grisu.pojo.AbstractPojo;
import io.grisu.pojo.annotations.Property;

public abstract class AbstractPersistentPojo extends AbstractPojo implements PersistentPojo {

    private final String name;
    private final Collection<String> columns;
    private final Collection<String> primaryKeys;
    private final Map<String, Index> indexes;

    public AbstractPersistentPojo() {
        super();

        columns = new ArrayList<>();
        primaryKeys = new ArrayList<>();
        indexes = new HashMap<>();

        final Entity entityAnnotation = this.getClass().getDeclaredAnnotation(Entity.class);
        if (entityAnnotation == null) {
            throw new RuntimeException("PersistentPojo '" + this.getClass().getName() + "'is missing the @Entity annotation");
        }
        name = entityAnnotation.name();

        for (Field field : this.getClass().getDeclaredFields()) {
            final Column columnAnnotation = field.getAnnotation(Column.class);
            final Property propertyAnnotation = field.getAnnotation(Property.class);
            final Indexed indexedAnnotation = field.getAnnotation(Indexed.class);

            if (propertyAnnotation != null) {
                String name = propertyAnnotation.name();

                if (columnAnnotation != null) {

                    columns.add(name);

                    if (columnAnnotation.primaryKey()) {
                        primaryKeys.add(name);
                    }

                }

                if (indexedAnnotation != null) {
                    indexes.put(name, new Index(indexedAnnotation.type()));
                }

            } else {
                if (columnAnnotation != null) {
                    throw new RuntimeException("Missing the @Property annotation which is required when using @Column");
                }

                if (indexedAnnotation != null) {
                    throw new RuntimeException("Missing the @Property annotation which is required when using @Indexed");
                }
            }

        }

    }

    @Override
    public String __getName() {
        return name;
    }

    @Override
    public Collection<String> __getColumns() {
        return columns;
    }

    @Override
    public Collection<String> __getPrimaryKeys() {
        return primaryKeys;
    }

    @Override
    public Map<String, Index> __getIndexes() {
        return indexes;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        for (String column : columns) {
            Object value = get(column);
            if (value != null) {
                hashCode += value.hashCode();
            }
        }
        return hashCode;
    }

    @Override
    public Collection<String> __changedColumns() {
        return __getColumns().stream().filter(key -> __hasChanged(key)).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
