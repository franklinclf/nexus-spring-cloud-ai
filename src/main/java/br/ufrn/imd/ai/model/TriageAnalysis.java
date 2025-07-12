package br.ufrn.imd.ai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TriageAnalysis {
    private String suggestedTitle;
    private String summary;
    private String impactAnalysis;
    private String urgencyAnalysis;
    private ProblemCategory predictedCategory;
    private Priority assignedPriority;
    private InitialApiResponse initialApiResponse;
    private String suggestedConsultantResponse;
}