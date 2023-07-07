package BookStore.Bookstore;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BookstoreApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(BookstoreApplication.class, args);
		} catch (BeanCreationException e) {
			System.out.println("Application fail to run, might cause by database service not available");
		}

	}

}
