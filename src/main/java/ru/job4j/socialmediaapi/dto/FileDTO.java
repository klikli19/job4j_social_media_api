package ru.job4j.socialmediaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO {
    private String name;
    private byte[] content;
    private String path;

    public FileDTO(String name, byte[] content) {
        this.name = name;
        this.content = content;
    }
}