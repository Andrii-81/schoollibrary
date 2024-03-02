package com.example.schoollibrary.service;

import com.example.schoollibrary.modelDTO.BookDTO;
import com.example.schoollibrary.modelDTO.MostPopularBooksDTO;
import com.example.schoollibrary.modelDTO.UserInfoDTO;
import com.example.schoollibrary.modelEntity.Book;

import java.util.List;

public interface LibraryService {

    UserInfoDTO userStatisticInfo (Integer id);

    List<MostPopularBooksDTO> findMostPopularBooks();
}
