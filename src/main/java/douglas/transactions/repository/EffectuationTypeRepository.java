package douglas.transactions.repository;

import douglas.transactions.domain.EffectuationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EffectuationTypeRepository extends JpaRepository<EffectuationType, Long> {
}
