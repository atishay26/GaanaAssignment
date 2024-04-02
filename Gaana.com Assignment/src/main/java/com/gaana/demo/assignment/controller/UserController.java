package com.gaana.demo.assignment.controller;

import com.gaana.demo.assignment.dto.BaseUserDto;
import com.gaana.demo.assignment.dto.UpdateUserDto;
import com.gaana.demo.assignment.enums.UserSortCriteria;
import com.gaana.demo.assignment.exceptions.CustomException;
import com.gaana.demo.assignment.entities.User;
import com.gaana.demo.assignment.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping
    public ResponseEntity createUser(@Valid @RequestBody BaseUserDto baseUserDto) throws CustomException {
        User userAdded = userService.saveUser(baseUserDto);
        log.debug("User added");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userAdded);
    }

    @PatchMapping
    public ResponseEntity updateUser(@Valid @RequestBody UpdateUserDto updateUserDto) throws CustomException {
        User userAdded = userService.updateUser(updateUserDto);
        log.debug("User updated");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userAdded);
    }

    @GetMapping("/{userId}")
    public ResponseEntity getUserById(@PathVariable("userId") Integer id) throws CustomException {
        User user = userService.getUserById(id);
        log.debug(String.format("User with id %s found.", id));
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity getAllUsers(@RequestParam(required = false, value = "sort_by") UserSortCriteria sortBy) {
        List<User> users = userService.getAllUsers(sortBy);
        return ResponseEntity.ok(users);
    }


}
