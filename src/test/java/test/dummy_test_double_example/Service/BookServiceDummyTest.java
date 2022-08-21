package test.dummy_test_double_example.Service;

import dummy_test_double_example.Repository.BookRepository;
import dummy_test_double_example.Service.BookService;
import dummy_test_double_example.Service.EmailService;
import dummy_test_double_example.Entity.Book;
import org.junit.jupiter.api.Test;
import test.dummy_test_double_example.Repository.DummyBookRepository;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookServiceDummyTest {
    @Test
    public void demoDummy() {
        BookRepository dummyBookRepository = new DummyBookRepository();
        EmailService emailService = new DummyEmailService(); // emailService is used only to make test compile, hence it is dummy test double
        BookService bookService = new BookService(dummyBookRepository,emailService);

        bookService.addBook(new Book("1234","Mockito In Action",250, LocalDate.now()));
        bookService.addBook(new Book("1235","Junit5 In Action",200, LocalDate.now()));

        assertEquals(2,bookService.findNumberOfBooks());

    }
}
