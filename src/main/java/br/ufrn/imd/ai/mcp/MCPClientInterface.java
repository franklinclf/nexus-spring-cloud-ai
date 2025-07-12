package br.ufrn.imd.ai.mcp;

import br.ufrn.imd.ai.model.Ticket;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PatchExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.invoker.HttpExchangeAdapter;

import java.util.UUID;

@HttpExchange
public interface MCPClientInterface extends HttpExchangeAdapter {

    @PostExchange("/tickets")
    Ticket register(@RequestBody Ticket ticket);

    @PatchExchange("/tickets")
    Ticket updateTicket(@RequestBody Ticket ticket);

    @GetExchange("/tickets/{id}")
    Ticket getTicket(@PathVariable("id") UUID id);

}