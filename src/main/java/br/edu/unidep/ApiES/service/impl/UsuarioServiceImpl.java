package br.edu.unidep.ApiES.service.impl;

import br.edu.unidep.ApiES.framework.CrudService;
import br.edu.unidep.ApiES.model.Usuario;
import br.edu.unidep.ApiES.service.UsuarioService;
import br.edu.unidep.ApiES.repository.UsuarioData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends CrudService<Usuario, Long> implements UsuarioService {

    @Autowired
    UsuarioData data;

    @Override
    protected JpaRepository<Usuario, Long> data() {
        return data;
    }

    @Override
    public UserDetails findByUsername(String email) {
        return data.findUsuarioByEmail(email);
    }
}
