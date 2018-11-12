package io.grisu.persistentpojo;

import java.util.Collection;
import java.util.Map;

import io.grisu.pojo.Pojo;

public interface PersistentPojo extends Pojo {

    String __getName();

    Collection<String> __getColumns();

    Collection<String> __getPrimaryKeys();

    Map<String, Index> __getIndexes();

    Collection<String> __changedColumns();

}
