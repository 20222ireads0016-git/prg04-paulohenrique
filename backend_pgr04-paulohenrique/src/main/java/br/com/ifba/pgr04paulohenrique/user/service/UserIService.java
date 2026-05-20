package br.com.ifba.pgr04paulohenrique.user.service;

import br.com.ifba.pgr04paulohenrique.user.User;
import java.util.List;


public interface UserIService {

    public User createNewUser(User user);
    public User findUserById(int id);
    public List<User> findAllUsers();
    public User updateUser(int id);
    public void deleteUser(int id);

}
