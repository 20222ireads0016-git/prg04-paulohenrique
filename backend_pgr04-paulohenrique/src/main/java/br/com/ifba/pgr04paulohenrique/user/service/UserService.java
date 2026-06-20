package br.com.ifba.pgr04paulohenrique.user.service;

import br.com.ifba.pgr04paulohenrique.infraestructure.exception.BusinessException;
import br.com.ifba.pgr04paulohenrique.user.entity.User;
import br.com.ifba.pgr04paulohenrique.user.repository.UserIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserIService {

    private final UserIRepository userRepository;

    @Override
    @Transactional
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
    @Transactional
    public User updateUser(int id, User updatedUser){

        User existingUser = findUserById(id);

        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setNomeCompleto(updatedUser.getNomeCompleto());
        existingUser.setTel(updatedUser.getTel());
        existingUser.setUsername(updatedUser.getUsername());

        return userRepository.save(existingUser);
    }

    @Override
    @Transactional
    public void deleteUser(int id){
        User existingUser = findUserById(id);
        userRepository.delete(existingUser);
    }
}
