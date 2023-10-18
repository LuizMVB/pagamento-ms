package br.com.microsservice.pagamentoms.schedule;

import br.com.microsservice.pagamentoms.service.AgendamentoPagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Classe responsável por efetivar os pagamentos realizados segundo um dado
 * período de tempo
 */
@Component
public class PagamentoScheduler {

    @Autowired
    private AgendamentoPagamentoService agendamentoPagamentoService;

    /**
     * TODO: o ideal aqui seria realizar a atualização dos registros no banco
     * através de um batch, porém como esse não é o foco do projeto, resolvi
     * seguir dessa forma
     */
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        agendamentoPagamentoService.efetivarPagamento();
    }

}
