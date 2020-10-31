package br.edu.unidep.ApiES.framework;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;
import java.util.List;

public abstract class CrudController<T, ID extends Serializable> implements ICrudController<T, ID> {

    protected abstract ICrudService<T, ID> service();

    @Override
    @PostMapping
    public T save(@RequestBody T entity) {
        return service().save(entity);
    }

    @Override
    @GetMapping(params = "id")
    public T findById(@RequestParam("id") ID id) {
        return service().findById(id);
    }

    @Override
    @GetMapping
    public List<T> findAll() {
        return service().findAll();
    }
}
