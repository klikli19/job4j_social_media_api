package ru.job4j.socialmediaapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.socialmediaapi.mapper.SubscribesMapper;
import ru.job4j.socialmediaapi.model.Friend;
import ru.job4j.socialmediaapi.model.Request;
import ru.job4j.socialmediaapi.model.User;
import ru.job4j.socialmediaapi.repository.FriendRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleFriendService implements FriendService {
    private final FriendRepository friendRepository;
    private final SubscribeService subscribeService;
    private final SubscribesMapper subscribesMapper;

    @Override
    public Friend save(Friend friend) {
        return friendRepository.save(friend);
    }

    @Override
    public List<Friend> findAll() {
        return friendRepository.findAll();
    }

    @Override
    public Optional<Friend> findById(Long id) {
        return friendRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        friendRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void createFriend(User userOffer, User userAccept) {
        var newFriend = new Friend();
        newFriend.setUser(userOffer);
        newFriend.setFriend(userAccept);
        newFriend.setStatus(true);
        friendRepository.save(newFriend);
        subscribeService.createSubscribe(userOffer, userAccept);
        friendRepository.save(newFriend);
    }

    @Override
    public void deleteFriend(User user, Friend friend) {
        if (friendRepository.findFriendByUserId(user.getId()).contains(friend)) {
            var subscribe = subscribeService.findSubscribeByUserId(friend.getFriend().getId(), friend.getUser().getId()).get();
            subscribeService.deleteSubscribe(user, subscribe);
            friendRepository.delete(friend);
        }
    }

    @Transactional
    @Override
    public void createFriendAndSubscribeFromRequest(Request request) {
        var friendDto = subscribesMapper.getSubscribesDTOFromRequest(request);
        var newFriend = friendDto.getFriend();
        var subscriberOffer = friendDto.getOffer();
        var subscriberAccept = friendDto.getAccepted();
        friendRepository.save(newFriend);
        subscribeService.save(subscriberOffer);
        if (request.isAccept()) {
            subscribeService.save(subscriberAccept);
        }
    }
}