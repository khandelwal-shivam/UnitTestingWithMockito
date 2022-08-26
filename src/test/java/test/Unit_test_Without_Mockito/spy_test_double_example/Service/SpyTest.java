package test.Unit_test_Without_Mockito.spy_test_double_example.Service;


import Unit_Testing_Without_Mockito.spy_test_double_example.Entity.Book;
import Unit_Testing_Without_Mockito.spy_test_double_example.Repository.BookRepository;
import org.junit.jupiter.api.Test;
import Unit_Testing_Without_Mockito.spy_test_double_example.Service.BookService;
import org.mockito.Mockito;
import test.Unit_test_Without_Mockito.spy_test_double_example.Repository.BookRepositorySpy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

public class SpyTest {

    @Test
    public void demoSpy() {
        BookRepositorySpy bookRepositorySpy = new BookRepositorySpy();
        BookService bookService = new BookService(bookRepositorySpy);
        bookService.addBook(new Book("1234","Mockito In Action",250, LocalDate.now()));
        bookService.addBook(new Book("1235","Junit5 In Action",200, LocalDate.now()));

        assertEquals(2,bookRepositorySpy.timeCalled());
        assertTrue(bookRepositorySpy.calledWith(new Book("1235","Junit5 In Action",200, LocalDate.now())));
    }
    @Test
    public void demoSpyWithMockito() {
        BookRepository bookRepositorySpy = Mockito.spy(BookRepository.class);
        BookService bookService = new BookService(bookRepositorySpy);
        Book book1 = new Book("1234","Mockito In Action",250, LocalDate.now());
        Book book2 = new Book("1235","Junit5 In Action",200, LocalDate.now());

        bookService.addBook(book1);
        bookService.addBook(book2);

        Mockito.verify(bookRepositorySpy).save(book1);
        Mockito.verify(bookRepositorySpy,Mockito.times(1)).save(book2);
    }
}
