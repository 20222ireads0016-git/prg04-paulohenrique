package br.com.ifba.pgr04paulohenrique.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPostRequestDto {

    @NotBlank(message = "O nome de usuário não é valido")
    private String username;

    @NotBlank(message = "A senha é obrigatória")
    private String password;

    @NotBlank(message = "O nome não pode estar vazio")
    @JsonProperty (value = "nome_completo")
    private String nomeCompleto;

    @NotBlank(message = "O email é obrigatorio")
    @Email(message = "Formato do Email inválido")
    private String email;

    private String tel;

}
