package ru.job4j.socialmediaapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.job4j.socialmediaapi.dto.PostDTO;
import ru.job4j.socialmediaapi.model.Post;
import ru.job4j.socialmediaapi.service.PostService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/post")
public class PostController {
    private final PostService postService;

    @GetMapping("/{postId}")
    public ResponseEntity<Post> get(@PathVariable("postId") Long postId) {
        return postService.findById(postId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PostDTO> save(@RequestBody PostDTO post) {
        postService.create(post);
        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(post.getId())
                .toUri();
        return ResponseEntity.status(HttpStatus.CREATED).location(uri).body(post);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody PostDTO post) {
        if (postService.updateFormDTO(post)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public void change(@RequestBody PostDTO post) {
        postService.updateFormDTO(post);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> removeById(@PathVariable long postId) {
        if (postService.deleteById(postId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Post> findAll() {
        return postService.findAll();
    }
}