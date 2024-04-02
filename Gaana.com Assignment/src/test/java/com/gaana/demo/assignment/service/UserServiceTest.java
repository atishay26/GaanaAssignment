package com.gaana.demo.assignment.service;

import com.gaana.demo.assignment.entities.User;
import com.gaana.demo.assignment.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUser() {
        User user = new User();
        Mockito.when(userRepository.findById(any())).thenReturn(java.util.Optional.of(user));
        User actual = userService.getUserById(1);
        Assert.assertEquals(actual, user);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetUserException() {
        User user = new User();
        Mockito.when(userRepository.findById(any())).thenReturn(Optional.empty());
        User actual = userService.getUserById(1);
    }
}
