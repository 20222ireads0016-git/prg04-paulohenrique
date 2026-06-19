package br.com.ifba.pgr04paulohenrique.user.service;

import br.com.ifba.pgr04paulohenrique.infraestructure.exception.BusinessException;
import br.com.ifba.pgr04paulohenrique.user.entity.User;
import br.com.ifba.pgr04paulohenrique.user.repository.UserIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserIService {

    private final UserIRepository userRepository;

    @Override
    public User createNewUser(User user){
        return userRepository.save(user);
    }

    @Override
    public User findUserById(int id){
        return userRepository.findById(id).orElseThrow(() -> new BusinessException("Usuário não encontrado com o ID: " + id));
    }

    @Override
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public User updateUser(int id){
        return userRepository.save(findUserById(id));
    }

    @Override
    public void deleteUser(int id){
        userRepository.delete(findUserById(id));
    }
}
