package br.com.ifba.pgr04paulohenrique.user.repository;

import br.com.ifba.pgr04paulohenrique.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserIRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmailOrUsername(String email, String username);
}
