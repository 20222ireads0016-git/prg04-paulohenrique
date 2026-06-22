package br.com.ifba.pgr04paulohenrique.permission.entity;

import br.com.ifba.pgr04paulohenrique.infraestructure.entity.PersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "permissions")
public class Permission extends PersistenceEntity {

    @Column(name = "permission_name",nullable = false, unique = true)
    private String permissionName;

}
