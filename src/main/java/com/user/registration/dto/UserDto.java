package com.user.registration.dto;
import java.util.List;
public record UserDto(
        String name,
        String email,
        String password,
        List<PhoneDto> phones
) {}
