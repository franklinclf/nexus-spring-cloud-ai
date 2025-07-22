package br.ufrn.imd.ai.service;

import br.ufrn.imd.ai.model.Ticket;
import br.ufrn.imd.ai.model.TriageAnalysis;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PromptingService {

    private final ChatClient chatClient;
    private final DataService dataService;

    @Value("classpath:prompt/system.md")
    private Resource systemRole;

    @Value("classpath:prompt/search.md")
    private Resource searchRole;
    public PromptingService(ChatClient.Builder chatClient, DataService dataService, ToolCallbackProvider tools) {
        this.chatClient = chatClient.defaultOptions(ChatOptions.builder()
                        .temperature(0.4)
                        .build())
                .defaultToolCallbacks(tools)
                .build();
        this.dataService = dataService;
    }

    public TriageAnalysis getAnalysis(String prompt) {
        return chatClient.prompt()
                .advisors(new QuestionAnswerAdvisor(dataService.getStore()))
                .system(systemRole)
                .user(prompt)
                .call().entity(TriageAnalysis.class);
    }

    public List<Ticket> findTicketsBySimilarity(String query) {
        return chatClient.prompt()
                .advisors(new QuestionAnswerAdvisor(dataService.getStore()))
                .system(searchRole)
                .toolNames("searchTickets")
                .user(query)
                .call()
                .entity(new ParameterizedTypeReference<>() {});
    }
}
