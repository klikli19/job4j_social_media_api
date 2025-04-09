package ru.job4j.socialmediaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.job4j.socialmediaapi.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("""
             select u from User as u where u.login = :login and u.password = :password""")
    Optional<User> findByLoginAndPassword(@Param("login") String login, @Param("password") String password);

    @Query("""
             select user from User user join Subscribe s on user.id = s.userSubscriber.id  where s.userTo.id = :id
             """)
    List<User> findBySubscribe(@Param("id") Long id);

    @Query("""
             select u from User u join Friend as f on u.id = f.friend.id where f.user.id = :id and f.status = true
             """)
    List<User> findFriendsByUserId(@Param("id") Long id);
}
