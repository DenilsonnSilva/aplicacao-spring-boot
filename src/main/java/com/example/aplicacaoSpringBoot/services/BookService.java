package com.example.aplicacaoSpringBoot.services;

import com.example.aplicacaoSpringBoot.models.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();
    private Long nextId = 1L;

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBookById(Long id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }

        return null;
    }

    public Book createBook(Book book) {
        book.setId(nextId++);
        books.add(book);

        return book;
    }

    public Book updateBook(Long id, Book updatedBook) {
        Book book = getBookById(id);

        if (book != null) {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());

            return book;
        }

        return null;
    }

    public boolean deleteBook(Long id) {
        Book book = getBookById(id);

        if (book != null) {
            books.remove(book);

            return true;
        }

        return false;
    }
}
