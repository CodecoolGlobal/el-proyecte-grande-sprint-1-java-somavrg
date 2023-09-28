package com.codecool.logmyphones.service.mapper;

import com.codecool.logmyphones.model.CompanyUser;
import com.codecool.logmyphones.model.DTO.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Set;

@Mapper(uses = {ContactMapper.class, DispatcherMapper.class}, componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    UserDTO toUserDTO(CompanyUser companyUser);
    Set<UserDTO> toUserDTOs(Set<CompanyUser> companyUsers);
    CompanyUser toCompanyUser(UserDTO userDTO);
    Set<CompanyUser> toCompanyUsers(Set<UserDTO> userDTOS);
}
