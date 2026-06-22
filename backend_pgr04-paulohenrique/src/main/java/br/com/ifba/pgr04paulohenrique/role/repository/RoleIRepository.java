package br.com.ifba.pgr04paulohenrique.role.repository;

import br.com.ifba.pgr04paulohenrique.role.entity.Role;
import br.com.ifba.pgr04paulohenrique.session.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleIRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(String roleName);
}