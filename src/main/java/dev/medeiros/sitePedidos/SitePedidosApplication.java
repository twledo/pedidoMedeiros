package dev.medeiros.sitePedidos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SitePedidosApplication {

	private static final Logger logger = LoggerFactory.getLogger(SitePedidosApplication.class);

	public static void main(String[] args) {
		logger.info("Iniciando a aplicação SitePedidos...");
		SpringApplication.run(SitePedidosApplication.class, args);
		logger.info("✅✅ Aplicação SitePedidos iniciada com sucesso.");
	}
}