package br.com.Okena.report.entity;

import br.com.Okena.usuarios.entity.Bairro;
import br.com.Okena.usuarios.entity.User;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    private User usuario;

    private String texto;

    @Enumerated(EnumType.STRING)
    private Bairro bairro;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    private LocalDateTime dataPost;

    public Report() {
    }

    public Report(User user, String texto, Bairro bairro, Categoria categoria, LocalDateTime data) {
        this.usuario = user;
        this.texto = texto;
        this.bairro = bairro;
        this.categoria = categoria;
        this.dataPost = data;
    }

    public Long getId() {
        return Id;
    }

    public User getUsuario() {
        return usuario;
    }

    public String getTexto() {
        return texto;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public LocalDateTime getDataPost() {
        return dataPost;
    }

    @Override
    public String toString() {
        return "Report{" +
                "Id=" + Id +
                ", usuario=" + usuario +
                ", texto='" + texto + '\'' +
                ", bairro=" + bairro +
                ", categoria=" + categoria +
                ", dataPost=" + dataPost +
                '}';
    }
}
