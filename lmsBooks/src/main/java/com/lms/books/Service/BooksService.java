package com.lms.books.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.lms.books.Model.Books;

@Service
public interface BooksService {
	
	Books addBook(Books book);
	List<Books> getAllBooks();
	Optional<Books> getBookById(int id);
	Books updateBook(Books book , int id);
	String deleteBookById(int id);

}
