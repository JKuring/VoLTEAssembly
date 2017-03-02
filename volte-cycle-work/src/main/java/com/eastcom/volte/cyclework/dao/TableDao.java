package com.eastcom.volte.cyclework.dao;

import java.util.List;

/**
 * Created by linghang.kong on 2017/2/15.
 */
public interface TableDao<T> {

    public List<T> selectBy(Object condition);

    public List<T> selectAll();

    public void insert(T entity);

    public void update(T entity);

    public void delete(T entity);

}
