package ru.job4j.socialmediaapi.service;

import ru.job4j.socialmediaapi.dto.FileDTO;
import ru.job4j.socialmediaapi.model.File;

import java.util.List;
import java.util.Optional;

public interface FileService {
    File save(FileDTO fileDTO);

    List<File> findAll();

    Optional<FileDTO> findById(Long id);

    boolean deleteById(Long id);
}
