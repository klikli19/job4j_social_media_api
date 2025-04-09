package ru.job4j.socialmediaapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.job4j.socialmediaapi.model.User;
import ru.job4j.socialmediaapi.service.UserService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<User> get(@PathVariable("userId") Long userId) {
        return userService.findById(userId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> (ResponseEntity.notFound().build()));
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        userService.save(user);
        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.status(HttpStatus.CREATED).location(uri).body(user);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody User user) {
        if (!userService.update(user)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public void change(@RequestBody User user) {
        userService.update(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> removeById(@PathVariable long userId) {
        if (!userService.deleteById(userId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAll() {
        return userService.findAll();
    }
}
