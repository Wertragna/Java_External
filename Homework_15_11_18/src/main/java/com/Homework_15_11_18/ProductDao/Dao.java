package com.Homework_15_11_18.ProductDao;

import java.util.List;

public interface Dao<K, V> {

    List<V> getAll();

    boolean update(V v);

    boolean delete(K k);

    boolean create(V v);

    V getById(K k);
}
