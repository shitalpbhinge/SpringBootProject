package com.example.SpringRestMysqlCurd.Controller;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.SpringRestMysqlCurd.Model.Book;
import com.example.SpringRestMysqlCurd.Repository.BookRepository;


@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/v1/mysqlapp")

public class BookController 
{
		@Autowired
		BookRepository bookRepository;
		
		@Autowired
		JdbcTemplate jdbcTemplate;
		
		
			@GetMapping("/getAllBooks")
			public List<Book> getAllBooks()
			{
				return bookRepository.findAll();
			}
			
			@GetMapping("/getBookById/{id}")
			public Optional<Book> getBookById(@PathVariable(value="id") long id)
			{
				return bookRepository.findById(id);
			}	
			
			@GetMapping("/getLatestByUuid") 
			public Book getLatestByAppUuid(@RequestParam(value = "uuid", required = false)  String appUuid)
		   {
				return bookRepository.getLatestByAppUuid(appUuid);
					
			}
			@PostMapping("/books")
		    public ResponseEntity<?> addABookToLibrary(@RequestBody Book book)
		    {
		        try
		        {
		            Book createdBook = bookRepository.save(new Book(book.getUuid(),book.getBook_name(), book.getAuthor_name(),
		                    book.getIsbn()));
		            return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
		        }
		        catch (Exception e)
		        {
		            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		        }
		    }
			
			@PutMapping("/updateBook/{id}")
			public Book updateBook(@PathVariable(value="id") long id, @RequestBody Book bookDetails)
			{
				
					Optional<Book> book = bookRepository.findById(id);
					Book book_new=book.get();
					book_new.setAuthor_name(bookDetails.getAuthor_name());
					book_new.setBook_name(bookDetails.getBook_name());
					book_new.setIsbn(bookDetails.getIsbn());

		         
					return bookRepository.save(book_new);
			
			}
			@DeleteMapping("/deleteBook/{id}")
			public void deleteBook(@PathVariable(value="id") long id)
			{
					Optional<Book> book=bookRepository.findById(id);
					Book book_new=book.get();
					bookRepository.delete(book_new);
			}
			/*@Scheduled(fixedDelay = 10000)
			@GetMapping("/publish")
			public void publishBookData() 
			{
				kafkaProducer.publishBookData();
			}*/
			
}