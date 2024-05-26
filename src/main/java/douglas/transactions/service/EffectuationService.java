package douglas.transactions.service;

import douglas.transactions.controller.dto.CreateEffectuationDto;
import douglas.transactions.domain.Effectuation;
import douglas.transactions.repository.EffectuationRepository;

public class EffectuationService {

    private final EffectuationRepository effectuationRepository;

    public EffectuationService(EffectuationRepository effectuationRepository){
        this.effectuationRepository = effectuationRepository;
    }
    public Effectuation createEffectuation(CreateEffectuationDto createEffectuationDto) {

        var effectuationDTO = effectuationRepository.findByEmail(createEffectuationDto.email());

        if (effectuationDTO.isPresent()) {

        }

        return effectuationRepository.save(createEffectuationDto.toEffectuation());
    }
}
