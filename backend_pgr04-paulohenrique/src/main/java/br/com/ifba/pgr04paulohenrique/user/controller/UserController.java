package br.com.ifba.pgr04paulohenrique.user.controller;

import br.com.ifba.pgr04paulohenrique.user.dto.UserGetRequestDto;
import br.com.ifba.pgr04paulohenrique.user.entity.User;
import br.com.ifba.pgr04paulohenrique.user.service.UserIService;
import br.com.ifba.pgr04paulohenrique.infraestructure.mapper.ObjectMapperUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController implements UserIController {

    private final UserIService userService;
    private final ObjectMapperUtil objectMapperUtil;

    @Override
    @PostMapping(path = "/createNewUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createNewUser(@Valid @RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createNewUser(user));
    }

    @Override
    @GetMapping(path = "/findUserById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> findUserById(@PathVariable("id") int id){
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @Override
    @GetMapping(path = "/findAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserGetRequestDto>> findAllUsers(){
        return ResponseEntity.ok(objectMapperUtil.mapAll(this.userService.findAllUsers(), UserGetRequestDto.class));
    }

    @Override
    @PutMapping(path = "/updateUser/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@PathVariable("id") int id, @Valid @RequestBody User user){
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @Override
    @DeleteMapping(path = "/deleteUser/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
