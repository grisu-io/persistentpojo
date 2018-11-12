package io.grisu.persistentpojo.supportingclasses;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.grisu.persistentpojo.AbstractPersistentPojo;
import io.grisu.persistentpojo.annotations.Column;
import io.grisu.persistentpojo.annotations.Entity;
import io.grisu.persistentpojo.annotations.Indexed;
import io.grisu.pojo.annotations.Property;

@Entity(name = "table_name")
public class MyTestingClass extends AbstractPersistentPojo {

    @Property(name = "key")
    @Column(primaryKey = true)
    private UUID keyColumn;

    @Property(name = "value")
    @Column
    @Indexed
    private String valueColumn;

    @Property(name = "date")
    private Date createdAt;

    @Property(name = "roles", serializer = true)
    private List<Role> roles;

    public MyTestingClass() {
    }

    public MyTestingClass setKeyColumn(UUID key) {
        this.keyColumn = key;
        return this;
    }

    public UUID getKeyColumn() {
        return this.keyColumn;
    }

    public String getValueColumn() {
        return valueColumn;
    }

    public MyTestingClass setValueColumn(String valueColumn) {
        this.valueColumn = valueColumn;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public MyTestingClass setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public MyTestingClass setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }

    public String _rolesOut(List<Role> roles) {
        return roles.stream().map(Role::name).collect(Collectors.joining(","));
    }

    public List<Role> _rolesIn(String roles) {
        return Stream.of(roles.split(",")).map(Role::valueOf).collect(Collectors.toList());
    }
}
