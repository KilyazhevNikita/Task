package com.example.task.service;

import com.example.task.dto.StatusDto;
import com.example.task.dto.UserDto;
import com.example.task.entity.User;

import java.util.List;

public interface UserService {

    Long addUser(UserDto userDto);

    User getUserById(Long userId);

    StatusDto changeStatusUser(Long userId, boolean status);

    List<User> getStatistics(Boolean status, Long id);
}
