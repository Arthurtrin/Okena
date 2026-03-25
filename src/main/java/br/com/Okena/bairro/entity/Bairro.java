package br.com.Okena.bairro.entity;

import br.com.Okena.bairro.dto.BairroRequestDTO;
import br.com.Okena.bairro.dto.BairroUpdateDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bairro")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double latitude;
    private Double longitude;

    public Bairro(BairroRequestDTO dados) {
        this.nome = dados.nome();
        this.latitude = dados.latitude();
        this.longitude = dados.longitude();
    }

    public void update(BairroUpdateDTO dados) {
        if(dados.nome() != null)
            this.nome = dados.nome();
        if(dados.latitude() != null)
            this.latitude = dados.latitude();
        if(dados.longitude() != null)
            this.longitude = dados.longitude();
    }
}
