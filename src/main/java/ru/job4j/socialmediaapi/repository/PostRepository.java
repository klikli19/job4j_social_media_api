package ru.job4j.socialmediaapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.socialmediaapi.model.Post;

import java.time.LocalDateTime;
import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findByUserId(Long id);

    List<Post> findByCreatedIsGreaterThanEqualAndCreatedIsLessThanEqual(LocalDateTime startAt, LocalDateTime endAt);

    Page<Post> findByOrderByCreatedDesc(Pageable pageable);

}
