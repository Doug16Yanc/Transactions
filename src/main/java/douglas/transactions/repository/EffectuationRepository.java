package douglas.transactions.repository;

import douglas.transactions.domain.Effectuation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EffectuationRepository extends JpaRepository<Effectuation, Long> {
    Optional<Effectuation> findByEmail(String email);
}
