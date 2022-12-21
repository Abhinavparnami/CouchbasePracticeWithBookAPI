package com.api.book.controllers;



import com.api.book.entities.Book;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.book.BookService;




@RestController
@RequestMapping(value = "/v1")
@CrossOrigin("*")
public class BookController {
	private final BookService bookService;
	//@Autowired
	//private Book book;



	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	//@RequestMapping(value="/books",method = RequestMethod.GET)
//	public Book getbooks() {
//		Book book = new Book();
//		book.setId(1);
//		book.setTitle("Java Refernce");
//		book.setAuthor("Abhinav");
//		return book;
//	}
	@Operation(summary = "This will fetch all books")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Found the book",
					content = {@Content(mediaType = "application/json")}),
			@ApiResponse(responseCode = "400", description = "Invalid id supplied",
					content = @Content)
	})
	@RequestMapping(value="/books",method = RequestMethod.GET)
	public Iterable<Book> getBooks()
	{
		return this.bookService.getAllBooks();
	}
	
	@RequestMapping(value="/books/{id}",method = RequestMethod.GET)
	public Object getBook(@PathVariable("id") int id) {
		return this.bookService.getBookById(id);
	}
	@RequestMapping(value="/books",method = RequestMethod.POST)
	public Book addBook(@RequestBody Book book) {
		Book b = this.bookService.addBook(book);
		return b;
	}
	
	@RequestMapping(value="/books/{bookId}",method = RequestMethod.DELETE)
	public void deleteBook(@PathVariable("bookId") int bookId) {
		this.bookService.deleteBook(bookId);
	}
	@RequestMapping(value="/books/{bookId}",method = RequestMethod.POST)
	public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId) {
		this.bookService.updateBook(book,bookId);
		return book;
		
	}
}
