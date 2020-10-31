package br.edu.unidep.ApiES.service;

import br.edu.unidep.ApiES.framework.ICrudService;
import br.edu.unidep.ApiES.model.Usuario;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioService extends ICrudService<Usuario, Long> {

    UserDetails findByUsername(String email);
}
