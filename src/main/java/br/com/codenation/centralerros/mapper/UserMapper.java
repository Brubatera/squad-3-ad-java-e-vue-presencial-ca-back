package br.com.codenation.centralerros.mapper;

import br.com.codenation.centralerros.dto.entitty.UserDTO;
import br.com.codenation.centralerros.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "code", target = "code"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "userType", target = "userType"),
    })
    User map(UserDTO user);

    UserDTO toDto(User user);

    List<User> mapList(List<UserDTO> products);
}
