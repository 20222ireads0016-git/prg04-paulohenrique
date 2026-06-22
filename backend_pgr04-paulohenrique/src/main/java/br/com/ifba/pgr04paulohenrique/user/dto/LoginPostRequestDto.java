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
public class LoginPostRequestDto {

    @NotBlank(message = "O nome de usuário não é valido")
    private String emailOrUsername;

    @NotBlank(message = "A senha é obrigatória")
    private String password;

}
