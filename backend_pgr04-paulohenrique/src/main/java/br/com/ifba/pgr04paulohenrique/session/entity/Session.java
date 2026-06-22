package br.com.ifba.pgr04paulohenrique.session.entity;

import br.com.ifba.pgr04paulohenrique.infraestructure.entity.PersistenceEntity;
import br.com.ifba.pgr04paulohenrique.user.entity.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "sessions")
public class Session extends PersistenceEntity {

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false)
    private LocalDateTime expiration;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
