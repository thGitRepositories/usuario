package com.javanauta.usuario.business.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EnderecoDto {

    private Long id;

    private String rua;

    private String cidade;

    private String estado;
    private String cep;
    private String numero;
    private String complemento;
}
