package BookStore.Bookstore.Repository;

import org.springframework.data.repository.CrudRepository;

import BookStore.Bookstore.Model.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
