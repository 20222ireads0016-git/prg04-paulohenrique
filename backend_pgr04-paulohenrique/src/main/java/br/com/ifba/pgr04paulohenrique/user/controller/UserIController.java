package br.com.ifba.pgr04paulohenrique.user.controller;

import br.com.ifba.pgr04paulohenrique.user.dto.UserGetRequestDto;
import br.com.ifba.pgr04paulohenrique.user.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserIController {

    public ResponseEntity<User> createNewUser(User user);
    public ResponseEntity<User> findUserById(int id);
    public ResponseEntity<List<UserGetRequestDto>> findAllUsers();
    public ResponseEntity<User> updateUser(int id, User user);
    public ResponseEntity<Void> deleteUser(int id);

}
