package br.ufrn.imd.ai.control;

import br.ufrn.imd.ai.model.Ticket;
import br.ufrn.imd.ai.service.PromptingService;
import org.springframework.ai.chat.client.ResponseEntity;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromptingController {

    private final PromptingService promptingService;

    public PromptingController(PromptingService promptingService) {
        this.promptingService = promptingService;
    }

    @PostMapping("/triage")
    public ResponseEntity<ChatResponse, Ticket> getAnalysis(@RequestBody String prompt) {
        return this.promptingService.getAnalysis(prompt);
    }
}
