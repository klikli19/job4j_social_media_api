package ru.job4j.socialmediaapi.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.job4j.socialmediaapi.dto.PostDTO;
import ru.job4j.socialmediaapi.model.Post;
import ru.job4j.socialmediaapi.model.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PostService {
    Post save(Post post);

    Post create(PostDTO postDTO);

    boolean update(Post post);

    boolean updateFormDTO(PostDTO postDTO);

    Optional<Post> findById(Long postId);

    List<Post> findAll();

    List<Post> findByToday(LocalDateTime today);

    List<Post> findByUserId(Long userId);

    Page<Post> findByOrderByCreatedDesc(Pageable pageable);

    Page<Post> findAllSubscriberPostsByUserOrderByCreatedDesc(Long id, Pageable pageable);

    boolean updateTitleAndDescription(Long postId, String title, String description);

    boolean updatePostByUser(User user, Post post);

    boolean deleteById(Long postId);

    boolean deletePostByUser(User user, Post post);

    boolean deleteFileByPostId(Long postId);
}
