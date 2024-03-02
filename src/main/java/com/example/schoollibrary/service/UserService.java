package com.example.schoollibrary.service;

import com.example.schoollibrary.modelDTO.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO getById(Integer id);

    List<UserDTO> getAll();
    void save(UserDTO book);
}
