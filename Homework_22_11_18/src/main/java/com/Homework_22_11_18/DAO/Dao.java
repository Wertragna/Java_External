package com.Homework_22_11_18.DAO;

import java.util.List;

public interface Dao<K, V> {

    List<V> getAll();

    boolean update(V v);

    boolean delete(K k);

    boolean create(V v);

    V getById(K k);
}
