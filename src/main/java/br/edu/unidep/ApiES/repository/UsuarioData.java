package br.edu.unidep.ApiES.repository;

import br.edu.unidep.ApiES.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioData extends JpaRepository<Usuario, Long> {

    UserDetails findUsuarioByEmail(String email);
}
