package ru.job4j.socialmediaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.job4j.socialmediaapi.model.Friend;
import ru.job4j.socialmediaapi.model.Subscribe;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscribesDTO {
    private Friend friend;
    private Subscribe offer;
    private Subscribe accepted;
}
