package br.edu.unidep.ApiES.resource.impl;

import br.edu.unidep.ApiES.framework.CrudController;
import br.edu.unidep.ApiES.framework.ICrudService;
import br.edu.unidep.ApiES.model.Usuario;
import br.edu.unidep.ApiES.resource.UsuarioController;
import br.edu.unidep.ApiES.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/usuario")
public class UsuarioControllerImpl extends CrudController<Usuario, Long> implements UsuarioController {

    @Autowired
    private UsuarioService service;

    @Override
    protected ICrudService<Usuario, Long> service() {
        return service;
    }

}
