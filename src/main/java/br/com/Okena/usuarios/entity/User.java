package br.com.Okena.usuarios.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "nome_de_usuario", unique = true)
    private String nomeDeUsuario;

    @Column(unique = true)
    private String email;

    private String bairro;

    @Column(unique = true)
    private String cpf;

    private String senha;

    public User() {
    }

    public User(String nome, String nomeDeUsuario, String email, String cpf, String senha) {
        this.nome = nome;
        this.nomeDeUsuario = nomeDeUsuario;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeDeUsuario() {
        return nomeDeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }
}

