# Especificação e Material de Implementação: Assistente de Triagem para Suporte ao Cliente

## Parte 1: Manual de Operações Corporativas da Nexus

Este documento estabelece as políticas, procedimentos e padrões operacionais da Nexus, uma provedora de serviços
gerenciados de TI (MSP). Ele foi projetado para servir como a fonte única de verdade para o Assistente de Triagem de IA,
fornecendo o contexto de negócios necessário para a categorização, priorização e resposta automatizada de tickets de
suporte.

### 1.1 Nexus: Visão, Missão e Valores

- **Visão:** Ser o parceiro tecnológico mais confiável para empresas de todos os tamanhos, transformando a TI em um
  catalisador de crescimento.
- **Missão:** Oferecer soluções de TI gerenciadas, seguras e de alto desempenho, com serviço ao cliente excepcional.
- **Valores:**
    - **Parceria com o Cliente**: Compromisso com o sucesso do cliente.
    - **Proatividade**: Antecipar problemas com monitoramento e manutenção.
    - **Excelência Técnica**: Adoção de boas práticas e tecnologias emergentes.
    - **Comunicação Clara**: Transparência durante todo o processo de suporte.

### 1.2 Acordos de Nível de Serviço (SLA)

Os Acordos de Nível de Serviço (SLAs) da Nexus são a nossa promessa de desempenho para nossos clientes. Eles definem
métricas mensuráveis para garantir responsabilidade e gerenciar expectativas de forma eficaz.

- **Horário Comercial**: Segunda a sexta, 9h às 18h (fuso do cliente). Todos os tempos de resposta e resolução de SLA
  são calculados com base neste horário.
- **Tempo de Resposta**: O tempo decorrido entre a criação de um ticket de suporte (log) e o momento em que um técnico
  da Nexus, ou o sistema automatizado, fornece o reconhecimento inicial ao cliente. Esta resposta inicial confirma o
  recebimento da solicitação e informa a prioridade atribuída..
- **Tempo de Resolução**: O tempo total decorrido desde a criação do ticket até a resolução completa do problema,
  confirmada com o cliente.

**Tabela 1: Metas de SLA por Prioridade**

| Prioridade | Nome    | Resposta | Resolução    |
|------------|---------|----------|--------------|
| P1         | Crítica | 15 min   | 4h úteis     |
| P2         | Alta    | 1h útil  | 8h úteis     |
| P3         | Média   | 4h úteis | 3 dias úteis |
| P4         | Baixa   | 8h úteis | 5 dias úteis |

### 1.3 Estrutura de Prioridade (ITIL)

Para garantir uma alocação de recursos justa e eficiente, a Nexus adota uma estrutura de priorização baseada nas
melhores práticas do ITIL (Information Technology Infrastructure Library). A prioridade de um incidente é determinada
pela combinação de seu **Impacto** nos negócios e sua **Urgência.**

#### 1.3.1 Impacto

O impacto mede a extensão do efeito adverso que um incidente tem sobre os processos de negócio do cliente. A avaliação
considera o número de usuários afetados, a criticidade dos sistemas envolvidos e as perdas financeiras ou de reputação
potenciais.

* **Impacto Alto (H):** Disrupção extensa ou generalizada.

    * **Critérios:** Afeta um departamento inteiro, uma função de negócio crítica (ex: vendas, faturamento), ou todos os
      clientes externos. Causa uma interrupção completa do trabalho para múltiplos usuários.
    * **Exemplos:** Falha no servidor principal de arquivos ou CRM; corrupção do banco de dados principal; interrupção
      da rede em toda a empresa; site de e-commerce do cliente fora do ar. 10

* **Impacto Médio (M):** Disrupção significativa.

    * **Critérios:** Afeta um grupo de usuários ou um serviço importante, mas não crítico. Soluções de contorno são
      difíceis ou ineficientes. A produtividade de uma equipe é severamente degradada.
    * **Exemplos:** A impressora compartilhada de um departamento está offline; um software específico usado por uma
      equipe está travando intermitentemente; problemas de desempenho em uma aplicação departamental. 11

* **Impacto Baixo (L):** Disrupção localizada.

    * **Critérios:** Afeta um único usuário ou uma função não essencial. Existe uma solução de contorno razoável. O
      impacto na produtividade geral do negócio é mínimo.

    * **Exemplos:** O teclado de um único usuário está com defeito; uma solicitação de instalação de software sem prazo
      imediato; um problema cosmético em uma aplicação interna.

#### 1.3.2 Urgência

A urgência mede a rapidez com que a resolução de um incidente é necessária para mitigar seu impacto nos negócios. A
avaliação considera a sensibilidade ao tempo, os prazos de negócio e a percepção do cliente.

* Urgência Alta (H): Atenção imediata necessária.

    * Critérios: Causa uma paralisação completa do trabalho para um ou mais usuários. Um prazo de negócio crítico está
      em risco. Impede operações essenciais.

    * Exemplos: Um executivo C-level não consegue acessar seu e-mail antes de uma reunião do conselho; um sistema de
      ponto de venda (PDV) para de funcionar durante o horário de pico.

* Urgência Média (M): Atenção rápida necessária.

    * Critérios: A produtividade do usuário está significativamente degradada, mas não completamente interrompida. O
      problema é frustrante, mas não impede todo o trabalho.

    * Exemplos: O computador de um usuário está extremamente lento, tornando o trabalho difícil, mas não impossível; um
      usuário não consegue acessar uma pasta de rede não crítica.

* Urgência Baixa (L): Atenção normal necessária.

    * Critérios: O problema é um inconveniente, mas não impede o trabalho essencial. A resolução pode ser agendada sem
      perdas operacionais significativas. O próprio usuário indica que não há pressa.

    * Exemplos: Um usuário solicita um novo mouse porque o atual está esteticamente danificado, mas funcional; uma
      solicitação de treinamento para um novo software.

#### 1.3.3 Matriz de Prioridade

| Impacto \ Urgência | Alta (H)    | Média (M) | Baixa (L) |
|--------------------|-------------|-----------|-----------|
| Alto (H)           | P1_CRITICAL | P2_HIGH   | P3_MEDIUM |
| Médio (M)          | P2_HIGH     | P3_MEDIUM | P4_LOW    |
| Baixo (L)          | P3_MEDIUM   | P4_LOW    | P4_LOW    |

### 1.4 Categorias de Problemas

Para facilitar o roteamento e a análise de tendências, todos os tickets são classificados em uma das seguintes
categorias predefinidas. Esta taxonomia fornece um conjunto de rótulos para o sistema de IA, uma característica comum em
sistemas de help desk modernos. As categorias são baseadas nos tipos de incidentes mais comuns em ambientes de TI.

* SOFTWARE:

    * Descrição: Problemas relacionados a aplicativos e sistemas operacionais.

    * Subcategorias: Desempenho de Aplicação, Travamento/Erro de Aplicação, Solicitação de Instalação/Atualização.

* NETWORK:

    * Descrição: Problemas relacionados à conectividade de rede, internet ou acesso remoto.

    * Subcategorias: Sem Conectividade, Rede Lenta, Problema de Acesso VPN.

* ACCOUNT_SECURITY:

    * Descrição: Problemas relacionados a contas de usuário, senhas e segurança da informação.

    * Subcategorias: Redefinição de Senha, Bloqueio de Conta, Suspeita de Phishing/Malware.

* SERVICE_REQUEST:

    * Descrição: Solicitações de novos serviços ou equipamentos que não são resultado de uma falha.

    * Subcategorias: Onboarding de Novo Usuário, Solicitação de Equipamento.

- UNKNOWN: Categoria fallback

## Parte 2: Especificação do Assistente de Triagem

### 2.1 Estrutura de Resposta da Triagem de Ticket

```json
{
  "$schema": "https://json-schema.org/draft/2020-12/schema",
  "$id": "https://example.com/schemas/triage-analysis.schema.json",
  "title": "TriageAnalysis",
  "type": "object",
  "properties": {
    "suggestedTitle": {
      "type": "string"
    },
    "summary": {
      "type": "string"
    },
    "impactAnalysis": {
      "type": "string"
    },
    "urgencyAnalysis": {
      "type": "string"
    },
    "predictedCategory": {
      "type": "string",
      "enum": [
        "HARDWARE",
        "SOFTWARE",
        "NETWORK",
        "ACCOUNT_SECURITY",
        "SERVICE_REQUEST",
        "UNKNOWN"
      ]
    },
    "assignedPriority": {
      "type": "string",
      "enum": [
        "P1_CRITICAL",
        "P2_HIGH",
        "P3_MEDIUM",
        "P4_LOW"
      ]
    },
    "initialApiResponse": {
      "type": "object",
      "properties": {
        "messageToCustomer": {
          "type": "string"
        },
        "estimatedResolutionTime": {
          "type": "string"
        }
      },
      "required": ["messageToCustomer", "estimatedResolutionTime"]
    },
    "suggestedConsultantResponse": {
      "type": "string"
    }
  },
  "required": [
    "suggestedTitle",
    "summary",
    "impactAnalysis",
    "urgencyAnalysis",
    "predictedCategory",
    "assignedPriority",
    "initialApiResponse",
    "suggestedConsultantResponse"
  ]
}
```

### 2.2 Exemplos Few-Shot

Os exemplos a seguir (pares de mensagens user/assistant) demonstram o comportamento esperado.

**Exemplo 1**: Servidor de vendas inativo (P1)

user:

```json
{
  "ticketId": null,
  "customerInfo": {
    "customerName": "Joana Silva",
    "companyName": "VendasRápidas Ltda",
    "contactEmail": "joana.silva@vendasrapida.com"
  },
  "title": "Alguém me ajuda!!!",
  "initialProblem": "SOCORRO!! O servidor principal de vendas está fora do ar, ninguém da minha equipe consegue acessar nosso CRM e não podemos processar nenhum pedido. Isso é um desastre completo! O nome da minha empresa é VendasRápidas Ltda e meu nome é Joana Silva.",
  "status": "ANALYZING",
  "creationTimestamp": "2025-07-09T16:00:00-03:00",
  "triageAnalysis": null
}
```

assistant:

```json
{
  "triageAnalysis": {
    "suggestedTitle": "Perda de acesso ao sistema CRM",
    "summary": "O servidor principal de vendas está inoperante, impedindo que a equipe acesse o CRM e processe pedidos.",
    "impactAnalysis": "Afeta uma função de negócio crítica (processamento de pedidos via CRM) e um departamento inteiro (vendas), com paralisação completa. Classificado como Impacto Alto (H) conforme o manual.",
    "urgencyAnalysis": "O relato indica uma paralisação completa com forte senso de urgência ('SOCORRO!!', 'desastre completo'), justificando Urgência Alta (H).",
    "predictedCategory": "HARDWARE",
    "assignedPriority": "P1_CRITICAL",
    "initialApiResponse": {
      "messageToCustomer": "Olá Joana, identificamos que sua solicitação envolve uma falha crítica no servidor de vendas. Este ticket foi classificado como Prioridade P1 - Crítica. Nossa equipe técnica foi acionada e está trabalhando para resolver o problema o mais rápido possível.",
      "estimatedResolutionTime": "4 horas úteis"
    },
    "suggestedConsultantResponse": "Iniciar imediatamente a análise do servidor de vendas da empresa VendasRápidas Ltda. Possível falha de hardware afetando o CRM. Prioridade P1. Confirmar conectividade com a infraestrutura e avaliar logs de eventos críticos. Informar cliente em até 30 minutos."
  }
}
```

**Exemplo 1**: Problema de Hardware Simples (P4)
user:

```json
{
  "ticketId": "b9f56e34-ec30-4e5e-8901-7c3df8ae8234",
  "customerInfo": {
    "customerName": "Carlos Pereira",
    "companyName": "Contabiliza Certo",
    "contactEmail": "carlos.pereira@contabilizacerto.com"
  },
  "title": "",
  "initialProblem": "Olá, o meu mouse está meio estranho, a roda de rolagem está agarrando. Não é urgente, mas eu gostaria de um novo quando tiverem uma oportunidade. Meu nome é Carlos Pereira, da Contabiliza Certo. Obrigado.",
  "status": "ANALYZING",
  "creationTimestamp": "2025-07-09T16:10:00-03:00"
}

```

assistant:

```json
{
  "triageAnalysis": {
    "suggestedTitle": "Solicitação de substituição de mouse com defeito",
    "summary": "Mouse do usuário está com falha na roda de rolagem. Solicita substituição quando for possível.",
    "impactAnalysis": "Afeta apenas um único usuário e não compromete uma função crítica. Há possibilidade de contorno ou uso parcial do dispositivo. Impacto classificado como Baixo (L).",
    "urgencyAnalysis": "O próprio usuário afirma que não é urgente e solicita o atendimento quando for possível. Urgência Baixa (L).",
    "predictedCategory": "HARDWARE",
    "assignedPriority": "P4_LOW",
    "initialApiResponse": {
      "messageToCustomer": "Olá Carlos, recebemos sua solicitação sobre o mouse com falha na rolagem. Como não é urgente, classificamos este ticket como Prioridade P4 - Baixa. Nossa equipe irá providenciar a substituição do equipamento dentro de até 5 dias úteis.",
      "estimatedResolutionTime": "5 dias úteis"
    },
    "suggestedConsultantResponse": "Separar mouse reserva para substituição conforme disponibilidade de estoque. Entrar em contato com Carlos Pereira para alinhar a entrega. Ticket classificado como Prioridade P4 (baixa urgência e impacto localizado)."
  }
}
```