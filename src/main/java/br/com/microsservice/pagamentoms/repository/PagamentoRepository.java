package br.com.microsservice.pagamentoms.repository;


import br.com.microsservice.pagamentoms.domain.StatusPagamentoEnum;
import br.com.microsservice.pagamentoms.domain.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

    List<Pagamento> findByStatus(StatusPagamentoEnum status);

}
