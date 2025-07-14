package br.ufrn.imd.ai.control;

import br.ufrn.imd.ai.model.Ticket;
import br.ufrn.imd.ai.service.PromptingService;
import jakarta.ws.rs.QueryParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PromptingController {

    private final PromptingService promptingService;

    public PromptingController(PromptingService promptingService) {
        this.promptingService = promptingService;
    }

    @PostMapping("/triage")
    public Ticket getAnalysis(@RequestBody String prompt) {
        return this.promptingService.getAnalysis(prompt);
    }

    @GetMapping("/find")
    public List<Ticket> findTicket(@QueryParam("query") String query) {
        return this.promptingService.findTicketsBySimilarity(query);
    }
}
