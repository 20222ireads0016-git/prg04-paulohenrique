package br.com.ifba.pgr04paulohenrique.role.entity;

import br.com.ifba.pgr04paulohenrique.infraestructure.entity.PersistenceEntity;
import br.com.ifba.pgr04paulohenrique.permission.entity.Permission;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "roles")
public class Role extends PersistenceEntity {

    @Column(name = "role_name", nullable = false, unique = true)
    private String roleName;

    @ManyToMany
    @JoinTable(name = "roles_permissions", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private List<Permission> permissions;

}
