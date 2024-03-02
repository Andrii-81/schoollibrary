package com.example.schoollibrary.service;

import com.example.schoollibrary.modelDTO.BookDTO;
import com.example.schoollibrary.modelEntity.Book;
import java.util.List;

public interface BookService {

    BookDTO getById(Integer id);

    List<BookDTO> getAll();
    void save(BookDTO book);



}
