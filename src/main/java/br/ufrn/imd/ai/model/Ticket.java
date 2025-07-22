package br.ufrn.imd.ai.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ticket {
    private UUID ticketId;
    private CustomerInfo customerInfo;
    private String title;
    private String initialProblem;
    private TicketStatus status;
    private LocalDateTime creationTimestamp;
    private TriageAnalysis triageAnalysis;
}
