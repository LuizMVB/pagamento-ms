CREATE TABLE pagamento (
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    ticket VARCHAR(100) NOT NULL,
    valor_total NUMERIC(8, 2) NOT NULL,
    status VARCHAR(9) NOT NULL,
    id_pedido BIGINT(20) UNIQUE NOT NULL COMMENT "Identificador do pedido atrelado a este pagamento - as informações deste pedido estão presentes na base pedido-db referente ao microsservice de pedido",
    data_efetivacao DATETIME,
    data_inclusao DATETIME NOT NULL,
    data_atualizacao DATETIME DEFAULT NULL,
    PRIMARY KEY(id)
);