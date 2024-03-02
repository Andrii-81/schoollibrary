package com.example.schoollibrary.service;

import com.example.schoollibrary.modelDTO.BookDTO;
import com.example.schoollibrary.modelEntity.Book;
import com.example.schoollibrary.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    //@Query(value = "SELECT * FROM books b WHERE b.id = 1", nativeQuery = true)
    public BookDTO getById(Integer id) {
        log.info("IN BookServiceImpl  method getById {}", id);
        //Book book = bookRepository.getById(id);
        Book book = bookRepository.findBookById(id);

        BookDTO bookDTO= new BookDTO(book.getId(), book.getBookName(), book.getAuthor(), book.getPubHouse(), book.getYear(),
            book.getCreatedAt(), book.getFlag());

        return bookDTO;
    }

    @Override
    public List<BookDTO> getAll() {
        log.info("IN BookServiceImpl  method getAll");
        List<Book> books = bookRepository.findAll();

        List<BookDTO> booksDTO = new ArrayList<>();
        for (Book b : books) {
            booksDTO.add(new BookDTO(b.getId(), b.getBookName(), b.getAuthor(), b.getPubHouse(), b.getYear(), b.getCreatedAt(), b.getFlag()));
        }
        return booksDTO;

    }

    @Override
    public void save(BookDTO bookDTO) {
        log.info("IN BookServiceImpl  method save", bookDTO);

        Book book= new Book(bookDTO.getId(), bookDTO.getBookName(), bookDTO.getAuthor(), bookDTO.getPubHouse(), bookDTO.getYear(),
                bookDTO.getCreatedAt(), bookDTO.getFlag());

        bookRepository.save(book);
    }

}
