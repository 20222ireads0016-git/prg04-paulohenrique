package br.com.ifba.pgr04paulohenrique.user.controller;

import br.com.ifba.pgr04paulohenrique.user.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserIController {

    public ResponseEntity<User> createNewUser(User user);
    public ResponseEntity<User> findUserById(int id);
    public ResponseEntity<List<User>> findAllUsers();
    public ResponseEntity<User> updateUser(int id);
    public ResponseEntity<Void> deleteUser(int id);

}
