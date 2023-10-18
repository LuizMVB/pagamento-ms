package br.com.microsservice.pagamentoms;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PagamentoMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PagamentoMsApplication.class, args);
	}

}
