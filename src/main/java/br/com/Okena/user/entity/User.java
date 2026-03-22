package br.com.Okena.user.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "nome_de_usuario", unique = true)
    private String nomeDeUsuario;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Bairro bairro;

    @Column(unique = true)
    private String cpf;

    private String senha;

    public User(String nome, String nomeDeUsuario, Bairro bairro, String email, String cpf, String senha) {
        this.nome = nome;
        this.nomeDeUsuario = nomeDeUsuario;
        this.bairro = bairro;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
    }

}

