package com.dominio.Forums.cadastro;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table (name ="usuario")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;


    public Usuario(DadosCadastro dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();

    }

    public void atualizarInforacao(DadosAtualizar dado) {
        if(dado.nome() != null){
            this.nome = dado.nome();
        }
        if(dado.senha() != null){
            this.senha = dado.senha();
        }
    }
}
