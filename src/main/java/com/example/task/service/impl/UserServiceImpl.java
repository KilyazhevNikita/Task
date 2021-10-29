package com.example.task.service.impl;

import com.example.task.dto.StatusDto;
import com.example.task.dto.UserDto;
import com.example.task.entity.User;
import com.example.task.exception.UserException;
import com.example.task.repository.UserRepository;
import com.example.task.service.UserService;
import com.example.task.utility.RequestDelayUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Long addUser(UserDto userDto) {
        if (userDto != null) {
            Timestamp timestamp = new Timestamp(userDto.getTimestamp());
            User user =
                    User.builder()
                            .name(userDto.getName())
                            .mail(userDto.getMail())
                            .online(userDto.isOnline())
                            .timestamp(timestamp)
                            .uri(userDto.getUri())
                            .build();
            return userRepository.save(user).getId();
        }
        throw new UserException("failed to add user");
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() ->
                new UserException("User by given id was not found"));
    }

    @Override
    public StatusDto changeStatusUser(Long userId, boolean status) {
        RequestDelayUtil.sendRequestDelay();
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            StatusDto statusDto = new StatusDto(user.getId(), user.isOnline(), status);
            Timestamp timestamp = new Timestamp(new Date().getTime());
            user.setOnline(status);
            user.setTimestamp(timestamp);
            userRepository.save(user);
            return statusDto;
        }
        throw new UserException("User by given id was not found");
    }

    @Override
    public List<User> getStatistics(Boolean status, Long id) {
        if (id != null) {
            Timestamp timestamp = new Timestamp(id);
            if (status != null) {
                return userRepository.findByOnlineAndTimestampAfter(status, timestamp);
            } else return userRepository.findByTimestampAfter(timestamp);
        } else if (status != null) return userRepository.findByOnline(status);
        else return userRepository.findAll();
    }
}
