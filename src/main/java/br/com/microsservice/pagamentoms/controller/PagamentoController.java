package br.com.microsservice.pagamentoms.controller;

import br.com.microsservice.pagamentoms.dto.PagamentoDTO;
import br.com.microsservice.pagamentoms.service.RealizacaoPagamentoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class PagamentoController {

    @Autowired
    private RealizacaoPagamentoService realizacaoPagamentoService;

    @PostMapping(value = "/pagamento")
    @ResponseStatus(HttpStatus.CREATED)
    public PagamentoDTO criar(@RequestBody @Valid PagamentoDTO pagamentoDTO) {
        return realizacaoPagamentoService.pagar(pagamentoDTO);
    }

    @GetMapping(value = "/pagamento/{id}")
    public PagamentoDTO detalhar(@PathVariable @NotNull Long id) {
        return realizacaoPagamentoService.detalhar(id);
    }

}
