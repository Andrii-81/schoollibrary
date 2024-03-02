package com.example.schoollibrary.service;

import com.example.schoollibrary.modelDTO.BookDTO;
import com.example.schoollibrary.modelDTO.UserDTO;
import com.example.schoollibrary.modelEntity.Book;
import com.example.schoollibrary.modelEntity.User;
import com.example.schoollibrary.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    final private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDTO getById(Integer id) {
        log.info("IN UserServiceImpl  method getById {}", id);
        User user = userRepository.findUserById(id);

        UserDTO userDTO= new UserDTO(user.getId(), user.getFirstName(), user.getLastName(), user.getBirthday(),
                    user.getPhoneNumber(), user.getEmail(), user.getAdress(), user.getCreatedAt());

        return userDTO;
    }

    @Override
    public List<UserDTO> getAll() {
        log.info("IN UserServiceImpl  method getAll");
        List<User> users = userRepository.findAll();

        List<UserDTO> usersDTO = new ArrayList<>();
        for (User u : users) {
            usersDTO.add(new UserDTO(u.getId(), u.getFirstName(), u.getLastName(), u.getBirthday(), u.getPhoneNumber(), u.getEmail(),
                    u.getAdress(), u.getCreatedAt()));
        }
        return usersDTO;
    }

    @Override
    public void save(UserDTO userDTO) {
        log.info("IN UserServiceImpl  method save", userDTO);

        User user= new User(userDTO.getId(), userDTO.getFirstName(), userDTO.getLastName(), userDTO.getBirthday(),
                userDTO.getPhoneNumber(), userDTO.getEmail(), userDTO.getAdress(), userDTO.getCreatedAt());

        userRepository.save(user);
    }
}
