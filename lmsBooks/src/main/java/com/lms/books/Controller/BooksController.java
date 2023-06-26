package com.lms.books.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.books.Model.Books;
import com.lms.books.Service.BooksService;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*")
public class BooksController {
	@Autowired
	private BooksService booksService;
	@CrossOrigin(origins = "*")
	
	//Post call to save a book
	@PostMapping()
	public Books addBooks(@RequestBody Books book) {
		return booksService.addBook(book);
	}	
	
	//Get Call to get all books
	@GetMapping("/all")
	public List<Books> getAllBooks(){
		return booksService.getAllBooks();
	}
	
	//Get Call to get book by id
	@GetMapping("{id}")
	public Optional<Books> getBookById(@PathVariable("id")int id){
		return booksService.getBookById(id);
	}
	
	//Update book depending on id by sending Book object
	@PutMapping("{id}")
	public Books updateBook(@PathVariable("id") int id , @RequestBody Books book) {
		return booksService.updateBook(book, id);
	}
	
	//Delete by id
	@DeleteMapping("{id}")
	public void deleteBook(@PathVariable("id")int id) {
		booksService.deleteBookById(id);
	}
	

}
