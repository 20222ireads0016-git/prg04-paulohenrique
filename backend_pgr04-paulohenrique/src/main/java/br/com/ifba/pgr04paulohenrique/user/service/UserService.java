package br.com.ifba.pgr04paulohenrique.user.service;

import br.com.ifba.pgr04paulohenrique.infraestructure.exception.BusinessException;
import br.com.ifba.pgr04paulohenrique.permission.repository.PermissionIRepository;
import br.com.ifba.pgr04paulohenrique.role.entity.Role;
import br.com.ifba.pgr04paulohenrique.role.repository.RoleIRepository;
import br.com.ifba.pgr04paulohenrique.session.entity.Session;
import br.com.ifba.pgr04paulohenrique.session.repository.SessionIRepository;
import br.com.ifba.pgr04paulohenrique.user.entity.User;
import br.com.ifba.pgr04paulohenrique.user.repository.UserIRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements UserIService {

    private final UserIRepository userRepository;
    private final SessionIRepository sessionRepository;
    private final RoleIRepository roleRepository;

    @Override
    @Transactional
    public User createNewUser(User user){
        Role defaltRole = roleRepository.findByRoleName("USER").orElseThrow(() ->  new BusinessException("Cargo padrão não encontrado no sistema"));

        user.setRoles(List.of(defaltRole));

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

    @Override
    @Transactional
    public String login(String emailOrUsername, String password){
        User user = userRepository.findByEmailOrUsername(emailOrUsername,emailOrUsername).orElseThrow(() -> new BusinessException("Usuario ou senha invalidos"));

        if(user.getPassword().equals(password)){
            Session session = new Session();
            session.setToken(UUID.randomUUID().toString());
            session.setExpiration(LocalDateTime.now().plusMinutes(120));
            session.setUser(user);
            sessionRepository.save(session);
            return session.getToken();
        } else {
            throw new BusinessException("Usuario ou senha invalidos");
        }
    }
}
