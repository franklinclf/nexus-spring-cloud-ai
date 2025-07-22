package br.ufrn.imd.ai.control;

import br.ufrn.imd.ai.model.Ticket;
import br.ufrn.imd.ai.model.TriageAnalysis;
import br.ufrn.imd.ai.service.PromptingService;
import jakarta.ws.rs.QueryParam;
import org.springframework.ai.util.json.JsonParser;
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
    public TriageAnalysis getAnalysis(@RequestBody Ticket customerTicket) {
        String parsedPrompt = JsonParser.toJson(customerTicket);
        return this.promptingService.getAnalysis(parsedPrompt);
    }

    @GetMapping("/find")
    public List<Ticket> findTicket(@QueryParam("query") String query) {
        return this.promptingService.findTicketsBySimilarity(query);
    }
}
