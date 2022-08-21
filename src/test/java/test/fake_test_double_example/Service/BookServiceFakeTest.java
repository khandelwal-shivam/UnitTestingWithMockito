package test.fake_test_double_example.Service;


import fake_test_double_example.Entity.Book;
import fake_test_double_example.Repository.BookRepository;
import test.fake_test_double_example.Repository.FakeBookRepository;
import fake_test_double_example.Service.BookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

public class BookServiceFakeTest {
    @Test
    public void fakeTest() {
        BookRepository fakeBookRepository = new FakeBookRepository();
        BookService bookService = new BookService(fakeBookRepository);
        bookService.addBook(new Book("1234","Mockito In Action",250, LocalDate.now()));
        bookService.addBook(new Book("1235","Junit5 In Action",200, LocalDate.now()));

        assertEquals(2,bookService.findNumberOfBooks());
    }
}
