package ru.job4j.socialmediaapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.job4j.socialmediaapi.dto.UserDTO;
import ru.job4j.socialmediaapi.model.User;

@Mapper(componentModel = "spring", uses = PostListMapper.class)
public interface UserMapper {
    @Mapping(target = "posts", qualifiedByName = {"PostListMapper", "findPostsByUserId"}, source = "user.id")
    UserDTO userToUserDto(User user);

    User userDTOToUser(UserDTO userDto);

}