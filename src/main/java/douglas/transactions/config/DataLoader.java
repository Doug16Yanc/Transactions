package douglas.transactions.config;

import douglas.transactions.domain.EffectuationType;
import douglas.transactions.repository.EffectuationTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final EffectuationTypeRepository effectuationTypeRepository;


    public DataLoader(EffectuationTypeRepository effectuationTypeRepository){
        this.effectuationTypeRepository = effectuationTypeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(EffectuationType.Enum.values())
                .forEach(effectuationType -> effectuationTypeRepository.save(effectuationType.get()));
    }
}
