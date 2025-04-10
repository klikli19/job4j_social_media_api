package ru.job4j.socialmediaapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.job4j.socialmediaapi.dto.PostDTO;
import ru.job4j.socialmediaapi.model.Post;

import java.util.List;

@Mapper(componentModel = "spring", uses = {FileMapper.class, FileListMapper.class})
public interface PostMapper {
    @Mapping(target = "fileList", qualifiedByName = {"FileListMapper", "findFilesByPostId"}, source = "post.id")
    PostDTO getModelFromEntity(Post post);

    Post getEntityFromDto(PostDTO postDto);

    default List<PostDTO> getPostsDTOFromList(List<Post> posts) {
        return posts.stream().map(this::getModelFromEntity).toList();
    }
}
