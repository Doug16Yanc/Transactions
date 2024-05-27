package douglas.transactions.controller;

import douglas.transactions.controller.dto.CreateEffectuationDto;
import douglas.transactions.controller.dto.ListEffectuationDto;
import douglas.transactions.domain.Effectuation;
import douglas.transactions.domain.EffectuationType;
import douglas.transactions.service.EffectuationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.introspector.MissingProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EffectuationController {

    private final EffectuationService effectuationService;

    public EffectuationController(EffectuationService effectuationService){
        this.effectuationService = effectuationService;
    }

    @PostMapping("/effectuations")
    public ResponseEntity<Effectuation> createEffectuation(@RequestBody CreateEffectuationDto createEffectuationDto){
        var effectuation = effectuationService.createEffectuation(createEffectuationDto);
        return ResponseEntity.ok(effectuation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Effectuation> findEffectuationById(@PathVariable("id") Long id){
        Optional<Effectuation> effectuation = this.effectuationService.findById(id);

        if (effectuation.isPresent()){
            Effectuation effectuation1 = effectuation.get();
            return ResponseEntity.ok(effectuation1);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/list_effectuations")
    public ResponseEntity<List<ListEffectuationDto>> listEffectuations() {
        List<Effectuation> effectuations = effectuationService.findAll();
        List<ListEffectuationDto> listEffectuationDtos = new ArrayList<>();
        if (!effectuations.isEmpty()){
            for (Effectuation effectuation : effectuations){

                listEffectuationDtos.add(new ListEffectuationDto(effectuation.getId(), effectuation.getDescription(), effectuation.getEmail(), effectuation.getBalance(), effectuation.getEffectuationType()));
            }
            return ResponseEntity.ok(listEffectuationDtos);
        }
        else {
            return ResponseEntity.noContent().build();
        }
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteEffectuationById(@PathVariable Long id) {
        Optional<Effectuation> effectuation = effectuationService.findById(id);

        if (effectuation.isPresent()){
            Effectuation effectuation1 = effectuation.get();
            effectuationService.delete(effectuation1);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Effectuation" + effectuation1.getId() + " deleted successfully!");
        }
        else {
            throw new RuntimeException("Effectuation not found");
        }
    }
}
