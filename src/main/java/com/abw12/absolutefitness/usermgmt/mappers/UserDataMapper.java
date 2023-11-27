package com.abw12.absolutefitness.usermgmt.mappers;

import com.abw12.absolutefitness.usermgmt.dto.UserDataDTO;
import com.abw12.absolutefitness.usermgmt.entity.UserDataDAO;
import com.abw12.absolutefitness.usermgmt.helper.OffsetDateTimeParser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserDataMapper extends OffsetDateTimeParser {

    UserDataMapper instance = Mappers.getMapper(UserDataMapper.class);

    @Mapping(source = "userCreatedAt", target = "userCreatedAt", qualifiedByName = "stringToOffsetDateTime")
    @Mapping(source = "userModifiedAt", target = "userModifiedAt", qualifiedByName = "stringToOffsetDateTime")
    UserDataDAO DtoToEntity(UserDataDTO userDataDTO);

    @Mapping(source = "userCreatedAt", target = "userCreatedAt", qualifiedByName = "offsetDateTimeToString")
    @Mapping(source = "userModifiedAt", target = "userModifiedAt", qualifiedByName = "offsetDateTimeToString")
    UserDataDTO entityToDto(UserDataDAO userDataDAO);
}
