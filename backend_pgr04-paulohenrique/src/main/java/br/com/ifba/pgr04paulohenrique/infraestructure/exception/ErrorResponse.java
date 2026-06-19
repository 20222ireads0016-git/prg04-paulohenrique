package br.com.ifba.pgr04paulohenrique.infraestructure.exception;

import lombok.Data;
import lombok.RequiredArgsConstructor;


import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class ErrorResponse {

    private LocalDateTime timestamp;
    private Integer status;
    private String message;
    private String error;
    private String path;

}
