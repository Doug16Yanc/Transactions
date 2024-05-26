package douglas.transactions.controller;

import douglas.transactions.controller.dto.CreateEffectuationDto;
import douglas.transactions.domain.Effectuation;
import douglas.transactions.service.EffectuationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
