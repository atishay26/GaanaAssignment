package com.gaana.demo.assignment.service;

import com.gaana.demo.assignment.dto.BaseUserDto;
import com.gaana.demo.assignment.dto.UpdateUserDto;
import com.gaana.demo.assignment.enums.ErrorEnum;
import com.gaana.demo.assignment.enums.UserSortCriteria;
import com.gaana.demo.assignment.exceptions.CustomException;
import com.gaana.demo.assignment.entities.User;
import com.gaana.demo.assignment.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(BaseUserDto baseUserDto) throws CustomException {
        User user = new User();
        BeanUtils.copyProperties(baseUserDto, user);
        userRepository.save(user);
        return user;
    }

    public User getUserById(Integer id) throws CustomException {
        return userRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorEnum.USER_NOT_FOUND,
                        String.format("User with id: %s not found.", id)));
    }

    public List<User> getAllUsers(UserSortCriteria sortBy) {
        return userRepository.findAll(getSortingCriteria(sortBy));
    }

    private Sort getSortingCriteria(UserSortCriteria sortBy) {
        return Objects.isNull(sortBy) ?
                Sort.by(Sort.Direction.ASC, "id") : Sort.by(Sort.Direction.ASC, sortBy.name());
    }

    public User updateUser(UpdateUserDto updateUserDto) throws CustomException {
        User user = getUserById(updateUserDto.getId());
        BeanUtils.copyProperties(updateUserDto, user);
        userRepository.save(user);
        return user;
    }
}
