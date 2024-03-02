package com.example.schoollibrary.rest;

import com.example.schoollibrary.modelDTO.BookDTO;
import com.example.schoollibrary.modelEntity.Book;
import com.example.schoollibrary.service.BookService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

//    @GetMapping("/v1")
//    public String getLoginPage() {
//        return "Hello World!";
//    }


// ПЕРЕДАВАТЬ НЕ Book Entity, a Book DAO
    @GetMapping("/{bookId}")
    public ResponseEntity<BookDTO> getBook(@PathVariable("bookId") Integer bookId) {
        if(bookId == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        BookDTO book = this.bookService.getById(bookId);// (Integer.toString(bookId)); // Integer или String ?????
        if(book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> bookList = bookService.getAll();
        if(bookList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<BookDTO> saveBook(@RequestBody BookDTO bookDTO) {
        HttpHeaders headers = new HttpHeaders();
        if (bookDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        bookService.save(bookDTO);
        return new ResponseEntity<>(bookDTO, headers, HttpStatus.CREATED);
    }



}
