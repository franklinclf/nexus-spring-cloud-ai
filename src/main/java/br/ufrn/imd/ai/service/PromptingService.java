package br.ufrn.imd.ai.service;

import br.ufrn.imd.ai.model.Ticket;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.ResponseEntity;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class PromptingService {

    private final ChatClient chatClient;
    private final DataService dataService;

    @Value("classpath:prompt/system.md")
    private Resource systemRole;

    public PromptingService(ChatClient.Builder chatClient, DataService dataService) {
        this.chatClient = chatClient.defaultOptions(ChatOptions.builder().temperature(0.4).build()).build();
        this.dataService = dataService;
    }

    public ResponseEntity<ChatResponse, Ticket> getAnalysis(String prompt) {
        return chatClient.prompt()
                .advisors(new QuestionAnswerAdvisor(dataService.getStore()))
                .system(systemRole)
                .user(prompt)
                .call().responseEntity(Ticket.class);
    }
}
