package br.ufrn.imd.ai.service;

import br.ufrn.imd.ai.model.Ticket;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class PromptingService {

    private final ChatClient chatClient;
    private final DataService dataService;

    @Value("classpath:prompt/system.md")
    private Resource systemRole;

    public PromptingService(ChatClient.Builder chatClient, DataService dataService, ToolCallbackProvider tools) {
        this.chatClient = chatClient.defaultOptions(ChatOptions.builder()
                        .temperature(0.4)
                        .build())
                .defaultToolCallbacks(tools)
                .build();
        this.dataService = dataService;
    }

    public Ticket getAnalysis(String prompt) {
        return chatClient.prompt()
                .advisors(new QuestionAnswerAdvisor(dataService.getStore()))
                .system(systemRole)
                .user(prompt)
                .call().entity(Ticket.class);
    }

    public List<Ticket> findTicketsBySimilarity(String query) {
        Ticket[] tickets = chatClient.prompt()
                .advisors(new QuestionAnswerAdvisor(dataService.getStore()))
                .toolNames("searchTicketsBySimilarity")
                .system(systemRole)
                .user(query)
                .call()
                .entity(Ticket[].class);
        return Arrays.asList(Objects.requireNonNull(tickets));
    }
}
