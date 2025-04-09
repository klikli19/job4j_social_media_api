package ru.job4j.socialmediaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.job4j.socialmediaapi.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime created;
    private User user;
    private List<FileDTO> fileList = new ArrayList<>();
}
