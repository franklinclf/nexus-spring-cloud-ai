package br.ufrn.imd.ai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InitialApiResponse {
    private String messageToCustomer;
    private String estimatedResolutionTime;
}
