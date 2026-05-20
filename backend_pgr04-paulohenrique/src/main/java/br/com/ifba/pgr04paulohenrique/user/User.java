package br.com.ifba.pgr04paulohenrique.user;

import br.com.ifba.pgr04paulohenrique.infraestructure.PersistenceEntity;
import br.com.ifba.pgr04paulohenrique.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User extends PersistenceEntity {

    @Column (nullable = false, unique = true)
    private String username;

    @Column (nullable = false)
    @JsonIgnore
    private String password;

    @Column (name = "nome_completo", nullable = false)
    @JsonProperty("nome_completo")
    private String nomeCompleto;

    @Column (nullable = false, unique = true)
    private String email;

    @Column (nullable = false)
    private String tel;

}
