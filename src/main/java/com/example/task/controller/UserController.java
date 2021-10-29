package com.example.task.controller;

import com.example.task.dto.StatusDto;
import com.example.task.dto.UserDto;
import com.example.task.entity.User;
import com.example.task.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> addUser(@RequestBody(required = false) UserDto userDto) {
        return new ResponseEntity<>(userService.addUser(userDto), HttpStatus.OK);
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @PutMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StatusDto> changeStatusUser(@PathVariable Long userId, @RequestParam boolean status) {
        return new ResponseEntity<>(userService.changeStatusUser(userId, status), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getStatistics(@RequestParam(required = false) Boolean status, @RequestParam(required = false) Long id) {
        return new ResponseEntity<>(userService.getStatistics(status, id), HttpStatus.OK);
    }
}
