package com.user.registration.mappers;

import com.user.registration.dto.PhoneDto;
import com.user.registration.dto.UserDto;
import com.user.registration.model.Phone;
import com.user.registration.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // Mapea el DTO UserDto a la entidad User
    @Mapping(target = "created", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "modified", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "lastLogin", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "token", source = "token")
    @Mapping(target = "active", constant = "true")
    User toEntity(UserDto userDto, String token);

    // Mapea PhoneDto a Phone
    List<Phone> toPhoneEntities(List<PhoneDto> phones);
}
