package com.example.CadastroUser.Service;

import com.example.CadastroUser.Models.Usuario;
import com.example.CadastroUser.Repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }

    public Usuario salvar(@Valid Usuario usuario){
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()){
            throw new RuntimeException("Este e-mail já está sendo utilizado");
        }
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(@Valid Usuario usuario){
        Usuario usuarioAtualizar = usuarioRepository.findById(usuario.getId())
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado!"));

        usuarioAtualizar.setNome(usuario.getNome());
        usuarioAtualizar.setEmail(usuario.getEmail());
        usuarioAtualizar.setSenha(usuario.getSenha());

        return usuarioRepository.save(usuarioAtualizar);
    }

    public void excluir(long id){
        Usuario usuarioAtualizar = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado!"));
        usuarioRepository.deleteById(id);
    }
}
