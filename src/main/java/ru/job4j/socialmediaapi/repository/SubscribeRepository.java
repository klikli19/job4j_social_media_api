package ru.job4j.socialmediaapi.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.socialmediaapi.model.Subscribe;

public interface SubscribeRepository extends CrudRepository<Subscribe, Long> {
}
