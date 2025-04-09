package ru.job4j.socialmediaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.job4j.socialmediaapi.model.User;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {
    private Long id;
    private LocalDateTime created = LocalDateTime.now();
    private User userFrom;
    private User userTo;
    boolean accept;
}
