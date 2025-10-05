package com.javanauta.usuario.business;


import com.javanauta.usuario.infrastructure.entity.Usuario;
import com.javanauta.usuario.infrastructure.exceptions.ConflictException;
import com.javanauta.usuario.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {



    private final UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(Usuario usuario){
        try {
            emailExiste(usuario.getEmail());

        }catch (ConflictException e){
            throw new ConflictException("Email ja cadastrado", e.getCause());
        }
        return usuarioRepository.save(usuario);
    }

    public void emailExiste(String email){
        try {
            boolean existe = verificaEmailExistente(email);
             if(existe==true){
                 throw new ConflictException("Email ja cadastrado  ->"+ email);
             }
        }catch (Exception e){
            throw new ConflictException("Email ja cadastrado  ->"+ e.getCause());
        }
    }

    public  boolean verificaEmailExistente(String email){
        return usuarioRepository.existsByEmail(email);
    }
}
