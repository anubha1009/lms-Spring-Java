package com.lms.books.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.books.Model.Books;
import com.lms.books.Repository.BooksRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BooksServiceImpl implements BooksService{
	
	@Autowired
	private BooksRepository bookrepository;
	
	@Override
	public Books addBook(Books book) {
		bookrepository.save(book);
		return book;
	}

	@Override
	public List<Books> getAllBooks() {
		return (List<Books>) bookrepository.findAll();
	}

	@Override
	public Optional<Books> getBookById(int id) {
		Optional<Books> foundBook = bookrepository.findById(id);
		
		return foundBook;
	}

	@Override
	public Books updateBook(Books book, int id) {
		Optional<Books> foundBook = bookrepository.findById(id);
		Books updatedBook = null;
		if(foundBook.isPresent()) {
			updatedBook = foundBook.get();
			System.out.println(book);
		}else {
			
		}
		updatedBook.setBookName(book.getBookName());
		updatedBook.setAuthorName(book.getAuthorName());
		updatedBook.setIssued(book.isIssued());
//		if(book.isIssued() ==true) {
		System.out.println(book.getIssuedTo());
		updatedBook.setIssuedTo(book.getIssuedTo());
//		}
//		else {
//			updatedBook.setIssuedTo("");
//		}
		bookrepository.save(updatedBook);
		return updatedBook;
	}

	@Override
	public String deleteBookById(int id) {
		bookrepository.deleteById(id);
		return "Deleted" ;
		
	}

}
