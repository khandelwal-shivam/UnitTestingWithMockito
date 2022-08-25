package test.Unit_test_Without_Mockito.dummy_test_double_example.Service;

import Unit_Testing_Without_Mockito.dummy_test_double_example.Repository.BookRepository;
import Unit_Testing_Without_Mockito.dummy_test_double_example.Service.BookService;
import Unit_Testing_Without_Mockito.dummy_test_double_example.Service.EmailService;
import Unit_Testing_Without_Mockito.dummy_test_double_example.Entity.Book;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import test.Unit_test_Without_Mockito.dummy_test_double_example.Repository.DummyBookRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    @Test
    public void demoDummyWithMockito() {
        BookRepository dummyBookRepository = Mockito.mock(BookRepository.class);
        EmailService emailService = Mockito.mock(EmailService.class);
        BookService bookService = new BookService(dummyBookRepository,emailService);
        Book book1 = new Book("1234","Mockito In Action",250, LocalDate.now());
        Book book2 = new Book("1235","Junit5 In Action",200, LocalDate.now());
        ArrayList<Book> books = new ArrayList<>(List.of(book1,book2));
        Mockito.when(dummyBookRepository.findAll()).thenReturn(books);
        assertEquals(2,bookService.findNumberOfBooks());
    }
}


