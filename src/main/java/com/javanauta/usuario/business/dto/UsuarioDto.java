package com.javanauta.usuario.business.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {
    private String nome;
    private String email;
    private String senha;
    private List<EnderecoDto> endereco;
    private List<TelefoneDto> telefone;
}
