package guru.springframework.spring7webapp.bootstrap;

import guru.springframework.spring7webapp.domain.Author;
import guru.springframework.spring7webapp.domain.Book;
import guru.springframework.spring7webapp.repositories.AuthorRepository;
import guru.springframework.spring7webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create Author
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        // Create Book
        Book ddd = new Book();
        ddd.setTitle("Domain Drive Design");
        ddd.setIsbn("123456");

        // Save Author and Book
        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);
        ericSaved.getBooks().add(dddSaved);
        authorRepository.save(ericSaved);

        // Create Author
        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        // Create Book
        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("54757585");

        // Save Author and Book
        Author rodSaved = authorRepository.save(rod);
        Book noEJBSave = bookRepository.save(noEJB);
        rodSaved.getBooks().add(noEJBSave);
        authorRepository.save(rodSaved);

        System.out.println(("In Bootstrap"));
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
    }
}
