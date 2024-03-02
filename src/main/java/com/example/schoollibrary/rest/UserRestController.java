package com.example.schoollibrary.rest;

import com.example.schoollibrary.modelDTO.BookDTO;
import com.example.schoollibrary.modelDTO.UserDTO;
import com.example.schoollibrary.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("userId") Integer userId) {
        if(userId == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        UserDTO user = this.userService.getById(userId);
        if(user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> userList = userService.getAll();
        if(userList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UserDTO> saveUSer(@RequestBody UserDTO userDTO) {
        HttpHeaders headers = new HttpHeaders();
        if (userDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userService.save(userDTO);
        return new ResponseEntity<>(userDTO, headers, HttpStatus.CREATED);
    }

}
