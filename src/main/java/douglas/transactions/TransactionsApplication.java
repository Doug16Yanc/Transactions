package douglas.transactions;

import douglas.transactions.controller.dto.CreateEffectuationDto;
import douglas.transactions.domain.EffectuationType;
import douglas.transactions.repository.EffectuationRepository;
import douglas.transactions.service.EffectuationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class TransactionsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TransactionsApplication.class, args);
	}

	@Autowired
	private EffectuationService effectuationService;

	@Override
	public void run(String... args) throws Exception {
		BigDecimal valor = new BigDecimal("80000");
	}
}
