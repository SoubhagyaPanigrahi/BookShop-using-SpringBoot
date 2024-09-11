package com.rest.book.restbookapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.book.restbookapi.dao.BookRepository;
import com.rest.book.restbookapi.entities.Book;

@Component
public class Bookservice {
    @Autowired
    private BookRepository bookRepository;
    // private static List<Book> list = new ArrayList<>();
    // static {
    // list.add(new Book(44, "Hello", "III"));
    // list.add(new Book(25, "The Ending", "Anonymous"));
    // list.add(new Book(77, "The heart", "Me"));
    // list.add(new Book(55, "Begins", "Batman"));
    // }

    // get all books
    public List<Book> getAllBooks() {
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    // Method to retrieve a book by its ID
    public Book getBookById(int id) {
        Book book = null;
        // book = list.stream()
        // .filter(e -> e.getId() == id)
        // .findFirst()
        // .orElse(null); // Or throw an exception if not found
        try {
            book = this.bookRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    // Adding book
    public Book addBook(Book b) {
        Book result = bookRepository.save(b);
        return result;
    }

    public void deleteBook(int bid) {
        // list = list.stream().filter((book) -> book.getId() !=
        // bid).collect(Collectors.toList());
        bookRepository.deleteById(bid);
    }

    public void updateBook(Book book, int bookId) {
        // list = list.stream().map(b-> {
        // if (b.getId()==bookId) {
        // b.setTitle(book.getTitle());
        // b.setAuthor(book.getAuthor());
        // }
        // return b;
        // }).collect(Collectors.toList());
        book.setId(bookId);
        bookRepository.save(book);
    }
}
