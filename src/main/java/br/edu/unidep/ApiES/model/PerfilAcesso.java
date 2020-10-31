package br.edu.unidep.ApiES.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

/**
 * @author Otavio Soares
 */

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "perfilacesso")
@Builder
public class PerfilAcesso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "perfilAcesso")
    private List<PerfilAcessoUsuario> perfilAcessoUsuarios;

}
