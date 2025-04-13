package com.example.CadastroUser.Controller;

import com.example.CadastroUser.Models.Usuario;
import com.example.CadastroUser.Service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listarTodos() {
        return usuarioService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@RequestBody Usuario usuario) {
        usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("Mensagem" + usuario.getNome(), "Cadastrado com sucesso!"));

    }
    @PutMapping
    public ResponseEntity<Map<String, Object>> atualizar(@RequestBody Usuario usuario) {
        usuarioService.atualizar(usuario);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("Mensagem", "atualizado com sucesso!"));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable long id) {
        usuarioService.excluir(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("Mensagem", "Excluido com sucesso!"));

    }




}
