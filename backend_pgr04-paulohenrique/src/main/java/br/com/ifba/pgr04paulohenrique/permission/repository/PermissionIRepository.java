package br.com.ifba.pgr04paulohenrique.permission.repository;

import br.com.ifba.pgr04paulohenrique.permission.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionIRepository extends JpaRepository<Permission, Integer> {
}