package backend.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backend.bookstore.domain.Book;
import backend.bookstore.domain.BookRepository;
import backend.bookstore.domain.Category;
import backend.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo2(CategoryRepository crepository, BookRepository repository) {

		return (args) -> {

			log.info("save categories");

			Category c1 = new Category("Fiction");
			Category c2 = new Category("Fantasy");
			Category c3 = new Category("Science");

			crepository.save(c1);
			crepository.save(c2);
			crepository.save(c3);

			log.info("save books");

			Book b1 = new Book("Kirja1", "Kirjailija1", 2020, "1234567890123", 19.99, c1);
			Book b2 = new Book("Kirja2", "Kirjailija2", 2021, "1234567890124", 24.99, c2);
			Book b3 = new Book("Kirja3", "Kirjailija3", 2022, "1234567890125", 29.99, c3);

			repository.save(b1);
			repository.save(b2);
			repository.save(b3);
		};
	}

}
