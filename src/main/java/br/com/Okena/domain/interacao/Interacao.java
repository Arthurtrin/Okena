package br.com.Okena.domain.interacao;

import br.com.Okena.domain.interacao.dto.InteracaoRequestDTO;
import br.com.Okena.domain.report.Report;
import br.com.Okena.domain.user.User;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "interacao",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_usuario_report",
                        columnNames = {"usuario_id", "report_id"}
                )
        }
)
public class Interacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private User usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "report_id", nullable = false)
    private Report report;

    @Enumerated(EnumType.STRING)
    private TipoInteracao tipoInteracao;

    @Column(name = "data")
    private LocalDateTime dataInteracao;

    public Interacao(User user, Report report, TipoInteracao tipoInteracao, LocalDateTime data) {
        this.usuario = user;
        this.report = report;
        this.tipoInteracao = tipoInteracao;
        this.dataInteracao = data;
    }
}
