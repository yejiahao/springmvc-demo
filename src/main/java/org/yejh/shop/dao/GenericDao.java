package org.yejh.shop.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface GenericDao<T, PK extends Serializable> {
    T getById(PK id);

    List<T> findAll(int offset, int length);

    PK save(T entity);

    PK update(T entity);

    void delete(PK id);

    Integer totalCounts();
}
