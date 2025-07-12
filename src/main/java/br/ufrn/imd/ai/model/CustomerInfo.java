package br.ufrn.imd.ai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInfo {

    private String customerName;
    private String companyName;
    private String contactEmail;

}