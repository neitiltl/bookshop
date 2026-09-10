package backend.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backend.bookstore.domain.Book;
import backend.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book s1 = new Book("Kirja1", "Kirjailija1", "2020", "1234567890123", "19.99");
			Book s2 = new Book("Kirja2", "Kirjailija2", "2021", "1234567890124", "24.99");

			repository.save(s1);
			repository.save(s2);
		};
	}
}
