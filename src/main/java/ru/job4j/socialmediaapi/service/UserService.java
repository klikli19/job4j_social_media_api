package ru.job4j.socialmediaapi.service;

import ru.job4j.socialmediaapi.dto.UserDTO;
import ru.job4j.socialmediaapi.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);

    Optional<User> findById(Long userId);

    Optional<User> findByLoginAndPassword(String login, String password);

    List<User> findAll();

    boolean deleteById(Long userId);

    boolean update(User user);

    List<User> findAllSubscribersById(Long userId);

    List<User> findAllFriendsById(Long userId);

    List<UserDTO> findUsersWithPostsList(List<Long> useIds);
}
