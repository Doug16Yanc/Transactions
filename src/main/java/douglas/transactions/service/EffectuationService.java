package douglas.transactions.service;

import douglas.transactions.controller.dto.CreateEffectuationDto;
import douglas.transactions.domain.Effectuation;
import douglas.transactions.exception.EffectuationAlreadyExistsException;
import douglas.transactions.repository.EffectuationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EffectuationService {

    private final EffectuationRepository effectuationRepository;

    public EffectuationService(EffectuationRepository effectuationRepository){
        this.effectuationRepository = effectuationRepository;
    }
    public Effectuation createEffectuation(CreateEffectuationDto createEffectuationDto) {

        var effectuationDTO = effectuationRepository.findByEmail(createEffectuationDto.email());

        if (effectuationDTO.isPresent()) {
            throw new EffectuationAlreadyExistsException("Effectuation data already exists.");
        }

        return effectuationRepository.save(createEffectuationDto.toEffectuation());
    }

    public Optional<Effectuation> findById(Long id) {
        return effectuationRepository.findById(id);
    }

    public List<Effectuation> findAll() {
        return effectuationRepository.findAll();
    }

    public void delete(Effectuation effectuation1) {
        effectuationRepository.delete(effectuation1);
    }

    public Effectuation updateEffectuation(Effectuation effectuation) {
        Optional<Effectuation> optionalEffectuation = effectuationRepository.findById(effectuation.getId());
        if (optionalEffectuation.isPresent()) {
            Effectuation existingEffectuation = optionalEffectuation.get();
            existingEffectuation.setDescription(effectuation.getDescription());
            existingEffectuation.setEmail(effectuation.getEmail());
            existingEffectuation.setBalance(effectuation.getBalance());
            existingEffectuation.setEffectuationType(effectuation.getEffectuationType());

            return effectuationRepository.save(existingEffectuation);
        } else {
            throw new RuntimeException("Effectuation not found");
        }
    }
}
