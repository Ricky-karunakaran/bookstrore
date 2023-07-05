package BookStore.Bookstore.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import BookStore.Bookstore.Model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

}
