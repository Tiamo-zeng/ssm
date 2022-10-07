package com.zs.controller;

import com.zs.domain.Book;
import com.zs.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Restult save(@RequestBody Book book) {
        boolean flag=bookService.save(book);
        return new Restult(flag ?Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @PutMapping
    public Restult update(@RequestBody Book book) {
        boolean flag=bookService.update(book);
        return new Restult(flag ?Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

    @DeleteMapping("/{id}")
    public Restult detele(@PathVariable Integer id) {
        boolean flag=bookService.detele(id);
        return new Restult(flag ?Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @GetMapping("/{id}")
    public Restult getById(@PathVariable Integer id) {
        Book book=bookService.getById(id);
        Integer code= book != null ? Code.GET_OK : Code.GET_ERR;
        String msg=book !=null ? "" : "数据查询失败，请重试!";
        return new Restult(code,book,msg);
    }

    @GetMapping
    public Restult getAll() {
        List<Book> bookList =bookService.getAll();
        Integer code= bookList != null ? Code.GET_OK : Code.GET_ERR;
        String msg=bookList !=null ? "" : "数据查询失败，请重试!";
        return new Restult(code,bookList,msg);
    }
}
