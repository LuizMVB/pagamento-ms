package br.com.microsservice.pagamentoms.service;

import br.com.microsservice.pagamentoms.domain.entity.Pagamento;
import br.com.microsservice.pagamentoms.dto.PagamentoDTO;
import br.com.microsservice.pagamentoms.repository.PagamentoRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealizacaoPagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public PagamentoDTO pagar(PagamentoDTO pagamentoDTO) {
        var pagamento = modelMapper.map(pagamentoDTO, Pagamento.class);
        pagamento = pagamentoRepository.save(pagamento);
        return modelMapper.map(pagamento, PagamentoDTO.class);
    }

    public PagamentoDTO detalhar(Long id) {
        var pedido = pagamentoRepository
                .findById(id)
                .orElseThrow(EntityExistsException::new);
        return modelMapper.map(pedido, PagamentoDTO.class);
    }

}
