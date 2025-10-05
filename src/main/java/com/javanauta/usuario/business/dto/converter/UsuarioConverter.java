package com.javanauta.usuario.business.dto.converter;

import com.javanauta.usuario.business.dto.EnderecoDto;
import com.javanauta.usuario.business.dto.TelefoneDto;
import com.javanauta.usuario.business.dto.UsuarioDto;
import com.javanauta.usuario.infrastructure.entity.Endereco;
import com.javanauta.usuario.infrastructure.entity.Telefone;
import com.javanauta.usuario.infrastructure.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioConverter {
    public Usuario converter(UsuarioDto usuarioDto) {
        return Usuario.builder()
                .nome(usuarioDto.getNome())
                .email(usuarioDto.getEmail())
                .senha(usuarioDto.getSenha())
                .enderecos(paraListaEndereco(usuarioDto.getEndereco()))
                .build();
    }

    public List<Endereco> paraListaEndereco(List<EnderecoDto> enderecoDtos) {
        return enderecoDtos.stream().map(this::paraEndereco).toList();
    }

    public Endereco paraEndereco(EnderecoDto enderecoDto) {
        return Endereco.builder()
                .rua(enderecoDto.getRua())
                .cidade(enderecoDto.getCidade())
                .complemento(enderecoDto.getComplemento())
                .numero(enderecoDto.getNumero())
                .cep(enderecoDto.getCep())
                .estado(enderecoDto.getEstado())
                .build();
    }

    public List<Telefone> paraListaTelefone(List<TelefoneDto> telefoneDtos) {
        return telefoneDtos.stream().map(this::paraTelefone).toList();
    }

    public Telefone paraTelefone(TelefoneDto telefoneDto) {
        return Telefone.builder()
                .numero(telefoneDto.getNumero())
                .dd(telefoneDto.getDd())
                .build();
    }


    public UsuarioDto converterDto(Usuario usuarioDto) {
        return UsuarioDto.builder()
                .nome(usuarioDto.getNome())
                .email(usuarioDto.getEmail())
                .senha(usuarioDto.getSenha())
                .endereco(paraListaEnderecoDto(usuarioDto.getEnderecos()))
                .build();
    }

    public List<EnderecoDto> paraListaEnderecoDto(List<Endereco> enderecoDtos) {
        return enderecoDtos.stream().map(this::paraEnderecoDto).toList();
    }

    public EnderecoDto paraEnderecoDto(Endereco enderecoDto) {
        return EnderecoDto.builder()
                .rua(enderecoDto.getRua())
                .cidade(enderecoDto.getCidade())
                .complemento(enderecoDto.getComplemento())
                .numero(enderecoDto.getNumero())
                .cep(enderecoDto.getCep())
                .estado(enderecoDto.getEstado())
                .build();
    }

    public List<TelefoneDto> paraListaTelefoneDto(List<Telefone> telefoneDtos) {
        return telefoneDtos.stream().map(this::paraTelefoneDto).toList();
    }

    public TelefoneDto paraTelefoneDto(Telefone telefoneDto) {
        return TelefoneDto.builder()
                .numero(telefoneDto.getNumero())
                .dd(telefoneDto.getDd())
                .build();
    }
}
