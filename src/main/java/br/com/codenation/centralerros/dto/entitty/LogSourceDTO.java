package br.com.codenation.centralerros.dto.entitty;

import br.com.codenation.centralerros.entity.Application;
import br.com.codenation.centralerros.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LogSourceDTO {
    private Long id;
    private Application application;
    private Company company;
}
