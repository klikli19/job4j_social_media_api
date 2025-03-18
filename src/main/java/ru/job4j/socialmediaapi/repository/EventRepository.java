package ru.job4j.socialmediaapi.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.socialmediaapi.model.Event;

public interface EventRepository extends CrudRepository<Event, Long> {
}
