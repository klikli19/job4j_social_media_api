package ru.job4j.socialmediaapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.job4j.socialmediaapi.dto.SubscribesDTO;
import ru.job4j.socialmediaapi.model.Friend;
import ru.job4j.socialmediaapi.model.Request;
import ru.job4j.socialmediaapi.model.Subscribe;

@Mapper(componentModel = "spring")
public interface SubscribesMapper {
    @Mapping(target = "offer", source = "userFrom")
    @Mapping(target = "friend", source = "userTo")
    SubscribesDTO getSubscribesDTOFromRequest(Request request);

    default Friend createFriendFromRequest(Request request) {
        var newFriend = new Friend();
        newFriend.setUser(request.getUserFrom());
        newFriend.setFriend(request.getUserTo());
        if (request.isAccept()) {
            newFriend.setStatus(true);
        }
        return newFriend;
    }

    default Subscribe createSubscribeFromRequest(Request request) {
        var newSubscribe = new Subscribe();
        newSubscribe.setUserSubscriber(request.getUserFrom());
        newSubscribe.setUserTo(request.getUserTo());
        return newSubscribe;
    }

    default Subscribe createSubscribeFromAcceptedRequest(Request request) {
        var newSubscribe = new Subscribe();
        newSubscribe.setUserSubscriber(request.getUserTo());
        newSubscribe.setUserTo(request.getUserFrom());
        return newSubscribe;
    }
}
