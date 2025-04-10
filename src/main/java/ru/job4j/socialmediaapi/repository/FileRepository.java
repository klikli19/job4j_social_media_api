package ru.job4j.socialmediaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.job4j.socialmediaapi.model.File;

public interface FileRepository extends JpaRepository<File, Long> {
    @Modifying
    @Query("""
             delete from File file where file.id=:id
             """)
    int delete(@Param("id") Long id);
}
