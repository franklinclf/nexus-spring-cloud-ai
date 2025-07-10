# Nexus Support - Serviço Spring Cloud + AI

![Java](https://img.shields.io/badge/Java-24-blue?logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.3-green?logo=springboot&logoColor=white)
![Spring Cloud](https://img.shields.io/badge/Spring_Cloud-2025.0.0-blueviolet?logo=spring&logoColor=white)
![Spring AI](https://img.shields.io/badge/Spring_AI-1.0.0-orange?logo=spring&logoColor=white)
![Microservices](https://img.shields.io/badge/Architecture-Microservices-lightgrey)

---

## 📚 Visão Geral do Projeto

Este repositório faz parte do projeto acadêmico **Nexus Support**, desenvolvido para a disciplina **DIM0614 -
Programação Distribuída** na **UFRN**. O Nexus Support é um **sistema de suporte distribuído** que visa otimizar a
gestão de chamados (tickets) utilizando uma arquitetura de microsserviços e inteligência artificial.

### Proposta do Nexus Support:

1. **Abertura de Chamado:** Um cliente da empresa abre um chamado (ticket) no painel do sistema, fornecendo informações
   detalhadas sobre o problema.
2. **Triagem e Análise por IA:** Este microsserviço, com capacidades de **Spring AI**, recebe o ticket e, utilizando *
   *Tools + MCP (Model Client Pattern)**, envia os dados para processamento. A IA realiza uma **triagem e análise
   inicial**, definindo parâmetros, categorizando o problema e sugerindo ações. Abordagens como **RAG (Retrieval
   Augmented Generation)** e **Prompt Engineering** serão exploradas para enriquecer essa análise.
3. **Resposta Breve ao Cliente:** A IA retorna uma mensagem concisa ao cliente, descrevendo a possível causa do
   problema, estimativa de tempo de resposta e outras informações relevantes.
4. **Dashboard de Tickets:** Todas as informações processadas são direcionadas para uma dashboard central de tickets.
   Aqui, um analista pode visualizar os dados, decidir o curso de ação, modificar campos do ticket e interagir
   diretamente com o cliente.

Este microsserviço é o **coração inteligente** do Nexus Support, demonstrando como a IA pode ser integrada em um
ambiente distribuído para melhorar a eficiência do suporte.

## 🚀 Tecnologias Utilizadas

Este serviço é construído sobre um stack robusto, aproveitando o ecossistema Spring:

* **Spring Boot (3.5.3):** Framework principal para o desenvolvimento de aplicações Java.
* **Java (24):** Linguagem de programação utilizada.
* **Spring Cloud (2025.0.0):** Para orquestração e padrões de microsserviços, incluindo:
    * `spring-cloud-starter-netflix-eureka-client`: **Descoberta de Serviços** (para registrar-se e encontrar outros
      serviços como o Config Server, Gateway, etc.).
    * `spring-cloud-starter-loadbalancer`: **Balanceamento de Carga** do lado do cliente.
    * `spring-cloud-starter-config`: **Gerenciamento Centralizado de Configurações**.
    * `spring-cloud-starter-circuitbreaker-reactor-resilience4j`: Implementação de **Circuit Breaker** e outros padrões
      para tolerância a falhas.
* **Spring AI (1.0.0):** Para integração de recursos de Inteligência Artificial:
    * `spring-ai-starter-model-openai`: Integração com modelos de linguagem OpenAI.
    * `spring-ai-markdown-document-reader`: Para leitura e processamento de documentos em Markdown (útil para RAG).
    * `spring-ai-starter-mcp-client-webflux`: Cliente reativo para interações com serviços de IA utilizando o **Model
      Client Pattern (MCP)**.
* **Spring WebFlux:** Para desenvolvimento de aplicações **reativas e não bloqueantes**, ideal para lidar com a
  comunicação assíncrona necessária com serviços de IA e outros microsserviços.
* **Micrometer Tracing & Zipkin:** Para **observabilidade e rastreamento distribuído**, fundamental em uma arquitetura
  de microsserviços.
* **Prometheus:** Para coleta de métricas e monitoramento.
* **Lombok:** Reduzir código boilerplate.
* **Spring Boot DevTools:** Ferramentas para desenvolvimento rápido.
* **Spring Boot Actuator:** Para monitoramento e gerenciamento da aplicação em produção.
* **Spring Boot Validation:** Para validação de dados de entrada.

## 🗺️ Outros Repositórios do Nexus Support

Este serviço é parte de um ecossistema maior. Você pode encontrar outros componentes do Nexus Support aqui:

* ⚙️ **[Nexus Support - Config Server](https://github.com/franklinclf/nexus-spring-cloud-config)**: Gerenciamento
  centralizado das configurações de todos os microsserviços.
* 🔍 **[Nexus Support - Eureka Discovery Service](https://github.com/franklinclf/nexus-spring-cloud-discovery)**: Serviço
  de descoberta para registrar e localizar outros microsserviços.
* 🧭 **[Nexus Support - Gateway](https://github.com/franklinclf/nexus-spring-cloud-gateway)**: Ponto de entrada unificado
  para todas as requisições, roteando-as para os serviços apropriados.
* 🧠 **[Nexus Support - MCP Server](https://github.com/franklinclf/nexus-spring-cloud-mcp)**: Servidor para o Model
  Client Pattern, orquestrando as interações com modelos de IA.
* ☁️ **[Nexus Support - Serverless Function](https://github.com/franklinclf/nexus-spring-serverless)**: Componente
  serverless para tarefas específicas ou escaláveis.

## 📈 Monitoramento e Observabilidade

Este serviço está configurado para observabilidade através de:

* **Actuator:** Disponível em `/actuator` para informações sobre o estado da aplicação.
* **Prometheus:** Métricas disponíveis em `/actuator/prometheus`.
* **Zipkin:** Rastreamento distribuído configurado para enviar traces para um servidor Zipkin.

---