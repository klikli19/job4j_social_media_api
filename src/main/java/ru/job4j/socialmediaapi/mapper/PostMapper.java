package ru.job4j.socialmediaapi.mapper;

import org.mapstruct.Mapper;
import ru.job4j.socialmediaapi.dto.PostDTO;
import ru.job4j.socialmediaapi.model.Post;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostDTO getModelFromEntity(Post post);

    Post getEntityFromDto(PostDTO postDto);
}
