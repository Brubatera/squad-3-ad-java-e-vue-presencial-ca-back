package br.com.codenation.centralerros.mapper;

import br.com.codenation.centralerros.dto.entitty.ApplicationDTO;
import br.com.codenation.centralerros.entity.Application;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "appName", target = "appName"),
            @Mapping(source = "codeCompany", target = "company.code")
    })
    Application map(ApplicationDTO applicationDTO);

    ApplicationDTO toDto(Application application);
}
