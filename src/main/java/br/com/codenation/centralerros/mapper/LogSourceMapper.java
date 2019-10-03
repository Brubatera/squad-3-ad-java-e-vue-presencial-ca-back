package br.com.codenation.centralerros.mapper;

import br.com.codenation.centralerros.dto.entitty.LogSourceDTO;
import br.com.codenation.centralerros.entity.LogSource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogSourceMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "application.appName", target = "application.appName"),
            @Mapping(source = "company.code", target = "application.company.code"),
    })
    LogSource map(LogSourceDTO logSourceDTO);

    List<LogSourceDTO> toDtoList(List<LogSource> logSources);

    LogSourceDTO toDto(LogSource logSource);

}
