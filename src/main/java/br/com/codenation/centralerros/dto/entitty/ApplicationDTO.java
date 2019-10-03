package br.com.codenation.centralerros.dto.entitty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationDTO {

    private Long id;
    private String appName;
    private String codeCompany;
}
