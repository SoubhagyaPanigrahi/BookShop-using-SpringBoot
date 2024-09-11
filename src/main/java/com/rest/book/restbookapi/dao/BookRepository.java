package com.rest.book.restbookapi.dao;

import org.springframework.data.repository.CrudRepository;

import com.rest.book.restbookapi.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
    public Book findById(int id);
}
