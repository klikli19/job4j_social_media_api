package ru.job4j.socialmediaapi.mapper;


import lombok.RequiredArgsConstructor;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import ru.job4j.socialmediaapi.dto.PostDTO;
import ru.job4j.socialmediaapi.repository.PostRepository;

import java.util.List;

@Named("PostListMapper")
@Component
@RequiredArgsConstructor
public class PostListMapper {
    private final PostMapper postMapper;
    private final PostRepository postRepository;

    @Named("findPostsByUserId")
    public List<PostDTO> findPostsByUserId(Long userId) {
        return postMapper.getPostsDTOFromList(postRepository.findByUserId(userId));
    }
}
