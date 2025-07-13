package br.ufrn.imd.ai.config;

import br.ufrn.imd.ai.mcp.MCPClientInterface;
import br.ufrn.imd.ai.service.MCPToolService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class MCPToolsConfiguration {

    @Value("${mcp.server.base-url}")
    private String mcpServerBaseUrl;

    @Bean
    public RestClient mcpRestClient(RestClient.Builder builder) {
        return builder
                .baseUrl(mcpServerBaseUrl)
                .build();
    }

    @Bean
    public HttpServiceProxyFactory httpServiceProxyFactory(RestClient mcpRestClient) {
        return HttpServiceProxyFactory.builderFor(RestClientAdapter.create(mcpRestClient))
                .build();
    }

    @Bean
    public MCPClientInterface mcpClientInterface(HttpServiceProxyFactory factory) {
        return factory.createClient(MCPClientInterface.class);
    }

    @Bean
    public MCPToolService mcpToolService(MCPClientInterface mcpClient) {
        return new MCPToolService(mcpClient);
    }
}