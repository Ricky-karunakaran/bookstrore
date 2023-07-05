package BookStore.Bookstore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import BookStore.Bookstore.Exception.ExceptionBase;
import BookStore.Bookstore.Model.Book;
import BookStore.Bookstore.Repository.BookRepository;

@CrossOrigin
@RestController
public class BookController extends ControllerBase {

    @Autowired // This will bind the book_repository to the BookRepository.java class
               // automatically.
    private BookRepository book_repository;

    @GetMapping("/books")
    public ResponseEntity<Object> getAlls() {
        try {
            Iterable<Book> response = book_repository.findAll();
            // Return all the attribute of Book with getter
            return new ResponseEntity<Object>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(new ExceptionBase(e.getMessage(), 500),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/book")
    public ResponseEntity<Object> addBook(@RequestBody Book newBook) {

        try {
            Book book = new Book();
            book.setTitle(newBook.getTitle());
            book.setAuthor(newBook.getAuthor());
            book.setISBN(newBook.getISBN());
            book.setPrice(newBook.getPrice());
            book.setPublication_year(newBook.getPublication_year());

            // Save the book to the database
            Book savedBook = book_repository.save(book);

            return new ResponseEntity<Object>(savedBook, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ExceptionBase(e.getMessage(), 500), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
