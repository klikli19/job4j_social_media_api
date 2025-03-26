package ru.job4j.socialmediaapi.repository;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.job4j.socialmediaapi.model.Post;
import ru.job4j.socialmediaapi.model.User;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PostRepositoryTest {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    private User user;

    @BeforeEach
    public void setUp() {
        postRepository.deleteAll();
        userRepository.deleteAll();
    }

    @AfterAll
    public void clearAll() {
        userRepository.deleteAll();
        postRepository.deleteAll();
    }

    @Test
    public void whenAddPost_thenReturnPost() {
        var post = new Post();
        post.setTitle("test");
        post.setDescription("test");
        post.setUser(user);
        postRepository.save(post);
        var foundPost = postRepository.findById(post.getId());
        assertThat(foundPost).isPresent();
        assertThat(foundPost.get()).isEqualTo(post);
    }

    @Test
    public void whenFindAllPosts_thenReturnAllPosts() {
        var post1 = new Post();
        post1.setTitle("test1");
        post1.setDescription("test1");
        post1.setUser(user);
        var post2 = new Post();
        post2.setTitle("test2");
        post2.setDescription("test2");
        post2.setUser(user);
        var post3 = new Post();
        post3.setTitle("test3");
        post3.setDescription("test3");
        post3.setUser(user);
        postRepository.save(post1);
        postRepository.save(post2);
        postRepository.save(post3);
        var foundPosts = postRepository.findAll();
        assertThat(foundPosts).hasSize(3);
        assertThat(foundPosts).isEqualTo(List.of(post1, post2, post3));
    }

    @Test
    public void whenFindPostById_thenReturnPost() {
        var post = new Post();
        post.setTitle("test1");
        post.setDescription("test1");
        post.setUser(user);
        postRepository.save(post);
        var foundPost = postRepository.findById(post.getId());
        assertThat(foundPost).isPresent();
        assertThat(foundPost.get().getId()).isEqualTo(post.getId());
    }

    @Test
    public void whenDeletePost_thenReturnPost() {
        var post = new Post();
        post.setTitle("test1");
        post.setDescription("test1");
        post.setUser(user);
        postRepository.save(post);
        var foundPost = postRepository.findById(post.getId());
        assertThat(foundPost).isPresent();
        postRepository.delete(foundPost.get());
        assertThat(postRepository.findAll()).isEmpty();
    }
}
