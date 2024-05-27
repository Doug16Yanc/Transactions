package douglas.transactions.controller.dto;

import douglas.transactions.domain.Effectuation;
import douglas.transactions.domain.EffectuationType;

import java.math.BigDecimal;

public record ListEffectuationDto(
        Long id,
        String description,
        String email,
        BigDecimal balance,
        EffectuationType effectuationType

) {
    public Effectuation toEffectuation() {
        return new ListEffectuationDto(
                id,
                description,
                email,
                balance,
                effectuationType
        ).toEffectuation();
    }
}