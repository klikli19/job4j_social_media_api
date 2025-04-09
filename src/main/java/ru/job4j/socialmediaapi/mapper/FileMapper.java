package ru.job4j.socialmediaapi.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.job4j.socialmediaapi.dto.FileDTO;
import ru.job4j.socialmediaapi.dto.PostDTO;
import ru.job4j.socialmediaapi.model.File;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface FileMapper {
    FileDTO getFileDtoFromFile(File file);

    File getFileFromDto(FileDTO dto);

    default List<FileDTO> getFileListDtoFromFileList(List<File> fileList) {
        return fileList.stream().map(this::getFileDtoFromFile).toList();
    }

    default List<File> getFileListFromDtoList(PostDTO postDto) {
        return postDto.getFileList().stream().map(this::getFileFromDto).toList();
    }
}