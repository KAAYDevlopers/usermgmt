package com.abw12.absolutefitness.usermgmt.mappers;

import com.abw12.absolutefitness.usermgmt.dto.UserAddressDTO;
import com.abw12.absolutefitness.usermgmt.entity.UserAddressDAO;
import com.abw12.absolutefitness.usermgmt.helper.OffsetDateTimeParser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserAddressMapper extends OffsetDateTimeParser {

    UserAddressMapper Instance = Mappers.getMapper(UserAddressMapper.class);
    @Mapping(source = "addressCreatedAt", target = "addressCreatedAt", qualifiedByName = "stringToOffsetDateTime")
    @Mapping(source = "addressModifiedAt", target = "addressModifiedAt", qualifiedByName = "stringToOffsetDateTime")
    UserAddressDAO DtoToEntity(UserAddressDTO userAddressDTO);
    @Mapping(source = "addressCreatedAt", target = "addressCreatedAt", qualifiedByName = "offsetDateTimeToString")
    @Mapping(source = "addressModifiedAt", target = "addressModifiedAt", qualifiedByName = "offsetDateTimeToString")
    UserAddressDTO entityToDTO(UserAddressDAO userAddressDAO);


}
