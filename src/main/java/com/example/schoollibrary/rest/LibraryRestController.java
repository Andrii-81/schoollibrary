package com.example.schoollibrary.rest;

import com.example.schoollibrary.modelDTO.BookDTO;
import com.example.schoollibrary.modelDTO.UserInfoDTO;
import com.example.schoollibrary.service.LibraryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library")
public class LibraryRestController {

    private final LibraryServiceImpl libraryService;

    public LibraryRestController(LibraryServiceImpl libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserInfoDTO> getUserAndBooksInfo(@PathVariable("userId") Integer userId) {
        if(userId == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        UserInfoDTO userInfo = this.libraryService.userStatisticInfo(userId);// (Integer.toString(bookId)); // Integer или String ?????
        if(userInfo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userInfo, HttpStatus.OK);

    }





    //findMostPopularBooks()

}
