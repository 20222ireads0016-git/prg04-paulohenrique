package br.com.ifba.pgr04paulohenrique.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPostRequestDto {

    private String username;

    private String password;

    @JsonProperty (value = "nome_completo")
    private String nomeCompleto;

    private String email;

    private String tel;

}
