package br.com.ifba.pgr04paulohenrique.user.repository;

import br.com.ifba.pgr04paulohenrique.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserIRepository extends JpaRepository<User,Integer> {

}
