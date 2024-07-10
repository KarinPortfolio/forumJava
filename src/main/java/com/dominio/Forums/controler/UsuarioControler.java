package com.dominio.Forums.controler;

import com.dominio.Forums.cadastro.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioControler {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastro dados){
        repository.save(new Usuario(dados));
    }
    @GetMapping
    public List<DadosListagemUsuario> listar(){
        return repository.findAll().stream().map(DadosListagemUsuario::new).toList();
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizar dados){
        var usuário = repository.getReferenceById(dados.id());
        usuário.atualizarInforacao(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }
}
