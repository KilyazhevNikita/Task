package com.example.task.repository;

import com.example.task.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByOnlineAndTimestampAfter(Boolean online, Timestamp timestamp);

    List<User> findByTimestampAfter(Timestamp timestamp);

    List<User> findByOnline(Boolean online);
}
