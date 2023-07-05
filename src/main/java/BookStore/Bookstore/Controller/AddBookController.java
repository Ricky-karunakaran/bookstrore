package BookStore.Bookstore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import BookStore.Bookstore.Exception.ExceptionBase;
import BookStore.Bookstore.Model.Book;
import BookStore.Bookstore.Repository.BookRepository;

@CrossOrigin
@RestController
@RequestMapping("/book")
public class AddBookController extends ControllerBase {

    @Autowired // This will bind the book_repository to the BookRepository.java class
               // automatically.
    private BookRepository book_repository;

    @PostMapping("/book")
    @ResponseBody
    public ResponseEntity<Object> addBook(@RequestBody String title,
                                            @RequestBody String author,
                                            @RequestBody String ISBN,
                                            @RequestBody double price,
                                            @RequestBody int publication_year) {
        try {

            // Create a new Book object using the values from the form
            Book book = new Book();
            book.setISBN(ISBN);
            book.setAuthor(author);
            book.setPrice(price);
            book.setPublication_year(publication_year);
            book.setTitle(title);

            // Save the book to the database
            Book savedBook = book_repository.save(book);

            return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ExceptionBase(e.getMessage(), 500), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

