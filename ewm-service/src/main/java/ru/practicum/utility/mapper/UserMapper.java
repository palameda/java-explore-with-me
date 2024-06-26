package ru.practicum.utility.mapper;

import org.mapstruct.Mapper;
import ru.practicum.dto.user.UserDto;
import ru.practicum.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper extends DefaultMapper<User, UserDto> {
}
