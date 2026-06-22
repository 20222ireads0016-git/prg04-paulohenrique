package br.com.ifba.pgr04paulohenrique.user.entity;

import br.com.ifba.pgr04paulohenrique.infraestructure.entity.PersistenceEntity;
import br.com.ifba.pgr04paulohenrique.role.entity.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User extends PersistenceEntity {

    @Column (nullable = false, unique = true)
    private String username;

    @Column (nullable = false)
    private String password;

    @Column (name = "nome_completo", nullable = false)
    @JsonProperty("nome_completo")
    private String nomeCompleto;

    @Column (nullable = false, unique = true)
    private String email;

    @Column (nullable = false)
    private String tel;

    @ManyToMany
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

}
