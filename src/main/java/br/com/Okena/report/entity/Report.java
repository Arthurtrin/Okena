package br.com.Okena.report.entity;

import br.com.Okena.report.dto.ReportUpdateDTO;
import br.com.Okena.usuarios.entity.Bairro;
import br.com.Okena.usuarios.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "report")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @JoinColumn(name = "usuario_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User usuario;

    private String texto;

    @Enumerated(EnumType.STRING)
    private Bairro bairro;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Column(name = "data")
    private LocalDateTime dataPost;

    public Report(User user, String texto, Bairro bairro, Categoria categoria, LocalDateTime data) {
        this.usuario = user;
        this.texto = texto;
        this.bairro = bairro;
        this.categoria = categoria;
        this.dataPost = data;
    }

    public Report(String texto, Bairro bairro, Categoria categoria, LocalDateTime data) {
        this.texto = texto;
        this.bairro = bairro;
        this.categoria = categoria;
        this.dataPost = data;
    }

    public void updateReport(ReportUpdateDTO dados, User usuario){
        this.usuario = usuario;
        if(dados.texto() != null)
            this.texto = dados.texto();
        if(dados.bairro() != null)
            this.bairro = Bairro.fromString(dados.bairro());
        if(dados.categoria() != null)
            this.categoria = Categoria.fromString(dados.categoria());
    }

}
