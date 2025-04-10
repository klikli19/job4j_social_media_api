package ru.job4j.socialmediaapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.socialmediaapi.dto.UserDTO;
import ru.job4j.socialmediaapi.mapper.UserMapper;
import ru.job4j.socialmediaapi.model.User;
import ru.job4j.socialmediaapi.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleUserService implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public Optional<User> findByLoginAndPassword(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteById(Long userId) {
        return userRepository.delete(userId) > 0L;
    }

    @Override
    public boolean update(User user) {
        return userRepository.update(user) > 0L;
    }

    @Override
    public List<User> findAllSubscribersById(Long userId) {
        return userRepository.findBySubscribe(userId);
    }

    @Override
    public List<User> findAllFriendsById(Long userId) {
        return userRepository.findFriendsByUserId(userId);
    }

    @Override
    public List<UserDTO> findUsersWithPostsList(List<Long> useIds) {
        return useIds.stream()
                .map(userRepository::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(userMapper::userToUserDto)
                .toList();
    }
}
