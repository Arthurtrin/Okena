package br.com.Okena.domain.report;

import br.com.Okena.domain.report.dto.ReportUpdateDTO;

import br.com.Okena.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    //Endereço
    private Double latitude;
    private Double longitude;
    private String estado;
    private String cidade;
    private String bairro;
    private String logradouro;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Column(name = "data")
    private LocalDateTime dataPost;

    public Report(
            User user,
            String texto,
            String estado,
            String cidade,
            String bairro,
            String logradouro,
            Double latitude,
            Double longitude,
            Categoria categoria,
            LocalDateTime data) {

        this.usuario = user;
        this.texto = texto;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.latitude = latitude;
        this.longitude = longitude;
        this.categoria = categoria;
        this.dataPost = data;
    }

    public Report(String texto,
                  String estado,
                  String cidade,
                  String bairro,
                  String logradouro,
                  Double latitude,
                  Double longitude,
                  Categoria categoria,
                  LocalDateTime data) {

        this.texto = texto;
        this.latitude = latitude;
        this.longitude = longitude;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.categoria = categoria;
        this.dataPost = data;
    }

    public void updateReport(ReportUpdateDTO dados, User usuario){
        this.usuario = usuario;
        if(dados.texto() != null)
            this.texto = dados.texto();
        if(dados.categoria() != null)
            this.categoria = Categoria.fromString(dados.categoria());
    }

}
