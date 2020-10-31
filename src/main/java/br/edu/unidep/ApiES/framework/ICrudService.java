package br.edu.unidep.ApiES.framework;

import java.io.Serializable;
import java.util.List;

public interface ICrudService<T, ID extends Serializable> {

    T save(T entity);

    T findById(ID id);

    void deleteById(ID id);

    List<T> findAll();

}
