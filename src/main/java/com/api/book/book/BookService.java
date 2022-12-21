package com.api.book.book;

import com.api.book.Repository.BookRepository;
import com.api.book.entities.Book;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Component;


@Component
@CacheConfig(cacheNames = "Subject")
public class BookService {

	private BookRepository bookrepo;

	public BookService(BookRepository bookRepository) {
		this.bookrepo = bookRepository;
	}
	@Cacheable(value = "BookList")
	public Iterable<Book> getAllBooks() {
		return bookrepo.findAll();
	}


	public Book getBookById(int id) {

		return bookrepo.findById(id);
	}


	@Caching(evict = {
			@CacheEvict(value="AddBookList", allEntries=true),})
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		bookrepo.save(book);
		return book;
	}
	@CacheEvict(key="#productId",value = "DeleteById")
	public void deleteBook(int bid) {
		Book bookDel = bookrepo.findById(bid);
		if(bookDel != null){
			bookrepo.deleteById(bid);
			return;
		}
		else {
			throw new RuntimeException("Book Not Found" +bid);
		}
	}
	@Caching(evict = {
			@CacheEvict(value="UpdateBook", allEntries=true)})
	public Book updateBook(Book book, int bookId) {
		// TODO Auto-generated method stub
//		list.stream().map(b->{
//			if(b.getId()==bookId) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
//		Book book = BookRepository.findById(bookId)


		Book b = bookrepo.findById(bookId);

		b.setTitle(book.getTitle());
		b.setAuthor(book.getAuthor());


		bookrepo.save(b);
		return b;
	}
}
