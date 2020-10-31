package br.edu.unidep.ApiES.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * @author Otavio Soares
 */
@Entity
@Data
@Table(name = "perfilacessousuario")
@AllArgsConstructor
@NoArgsConstructor
public class PerfilAcessoUsuario implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idusuario", foreignKey = @ForeignKey(name = "fk_perfilacessousuario_usuario"))
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idperfilacesso", foreignKey = @ForeignKey(name = "fk_perfilacessousuario_perfilacesso"))
    private PerfilAcesso perfilAcesso;

    @Override
    public String getAuthority() {
        return usuario.getEmail();
    }
}
