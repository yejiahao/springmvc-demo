package org.yejh.shop.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {
    T getById(PK id);

    List<T> findAll();

    PK save(T entity);

    PK update(T entity);

    void delete(PK id);
}
