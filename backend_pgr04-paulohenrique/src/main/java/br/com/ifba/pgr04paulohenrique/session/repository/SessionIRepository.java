package br.com.ifba.pgr04paulohenrique.session.repository;

import br.com.ifba.pgr04paulohenrique.session.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SessionIRepository extends JpaRepository<Session, Integer> {
    Optional<Session> findByToken(String token);
}