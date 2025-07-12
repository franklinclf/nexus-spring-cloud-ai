package br.ufrn.imd.ai.service;

import br.ufrn.imd.ai.mcp.MCPClientInterface;
import br.ufrn.imd.ai.model.Ticket;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class MCPToolService {

    private final MCPClientInterface mcpClient;

    public MCPToolService(MCPClientInterface mcpClient) {
        this.mcpClient = mcpClient;
    }

    @Tool(description = "Registrar um novo ticket de suporte feito por um cliente.")
    public Function<Ticket, Ticket> createTicketFunction() {
        return mcpClient::register;
    }
}
