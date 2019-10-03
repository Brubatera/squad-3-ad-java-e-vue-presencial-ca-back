package br.com.codenation.centralerros.dto.entitty;

import br.com.codenation.centralerros.entity.Company;
import br.com.codenation.centralerros.entity.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String name;
    private Company company;
    private UserType userType;
}
