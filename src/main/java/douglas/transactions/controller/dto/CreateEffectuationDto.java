package douglas.transactions.controller.dto;

import douglas.transactions.domain.Effectuation;
import douglas.transactions.domain.EffectuationType;

import java.math.BigDecimal;

public record CreateEffectuationDto(
        String description,
        String email,
        String password,
        BigDecimal balance,
        EffectuationType.Enum effectuationType

) {
    public Effectuation toEffectuation() {
        return new Effectuation(
                description,
                email,
                password,
                balance
        );
    }
    public Effectuation updateEffectuation() {
        return new Effectuation(
                description,
                email,
                password,
                balance
        );
    }
}
