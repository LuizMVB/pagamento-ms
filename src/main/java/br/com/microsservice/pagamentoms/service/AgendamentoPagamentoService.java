package br.com.microsservice.pagamentoms.service;

import br.com.microsservice.pagamentoms.domain.StatusPagamentoEnum;
import br.com.microsservice.pagamentoms.domain.entity.Pagamento;
import br.com.microsservice.pagamentoms.repository.PagamentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendamentoPagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * Realiza a efetivação do pagamento. Simula o consumo de um gateway de pagamento
     * que seria responsável por efetivar o pagamento de todos as requisições
     */
    @Transactional
    public void efetivarPagamento() {
        List<Pagamento> pagamentoList = pagamentoRepository.findByStatus(StatusPagamentoEnum.REALIZADO);

        // realiza o pagamento através da chamada de um gateway de pagamento e gera nota fiscal

        pagamentoList.forEach(pagamento -> {
            pagamento.setStatus(StatusPagamentoEnum.EFETIVADO);
            pagamento.setDataEfetivacao(LocalDateTime.now());
        });

        List<Pagamento> pagamentoEfetivadoList = pagamentoRepository.saveAll(pagamentoList);

        if(!CollectionUtils.isEmpty(pagamentoEfetivadoList)) {
            rabbitTemplate.convertAndSend("pagamento.concluido", pagamentoEfetivadoList);
        }
    }
}
