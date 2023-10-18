package br.com.microsservice.pagamentoms.domain.entity;

import br.com.microsservice.pagamentoms.domain.StatusPagamentoEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
@Data
@NoArgsConstructor
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String ticket = generateTicket();

    @Column
    private BigDecimal valorTotal;

    @Column(unique = true)
    private Long idPedido;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusPagamentoEnum status = StatusPagamentoEnum.REALIZADO;

    @Column
    private LocalDateTime dataEfetivacao;

    @Embedded
    private DataEmbeddable data = new DataEmbeddable();

    private String generateTicket() {
        long timestamp = System.currentTimeMillis();
        int randomNum = (int) (Math.random() * 1000);
        return UUID.randomUUID() + "-" + timestamp + "-" + randomNum;
    }

}
