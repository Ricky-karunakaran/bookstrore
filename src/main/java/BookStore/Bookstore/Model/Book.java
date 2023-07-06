package BookStore.Bookstore.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book extends ModelBase {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String author;
    private String ISBN;
    private Double price;
    private Integer publication_year;

    public Book() {
        // Default constructor is required for deserialization
    }

    public Book(String jsonString) {
        // Deserialize the JSON string and populate the fields
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Book temp = objectMapper.readValue(jsonString, Book.class);
            this.title = temp.title;
            this.author = temp.author;
            this.ISBN = temp.ISBN;
            this.price = temp.price;
            this.publication_year = temp.publication_year;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(Integer publication_year) {
        this.publication_year = publication_year;
    }

}
