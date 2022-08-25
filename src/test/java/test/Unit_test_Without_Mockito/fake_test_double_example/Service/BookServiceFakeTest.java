package test.Unit_test_Without_Mockito.fake_test_double_example.Service;


import Unit_Testing_Without_Mockito.fake_test_double_example.Entity.Book;
import Unit_Testing_Without_Mockito.fake_test_double_example.Repository.BookRepository;
import org.mockito.Mockito;
import test.Unit_test_Without_Mockito.fake_test_double_example.Repository.FakeBookRepository;
import Unit_Testing_Without_Mockito.fake_test_double_example.Service.BookService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookServiceFakeTest {
    @Test
    public void fakeTest() {
        BookRepository fakeBookRepository = new FakeBookRepository();
        BookService bookService = new BookService(fakeBookRepository);
        bookService.addBook(new Book("1234","Mockito In Action",250, LocalDate.now()));
        bookService.addBook(new Book("1235","Junit5 In Action",200, LocalDate.now()));

        assertEquals(2,bookService.findNumberOfBooks());
    }
    @Test
    public void fakeTestWithMockito() {
        BookRepository fakeBookRepository = Mockito.mock(BookRepository.class); //now we are not using FakeBookRepository.java that we were using earlier.
        BookService bookService = new BookService(fakeBookRepository);

        Book book1 = new Book("1234","Mockito In Action",250, LocalDate.now());
        Book book2 = new Book("1235","Junit5 In Action",200, LocalDate.now());

        ArrayList <Book> books = new ArrayList<>(List.of(book1,book2));

        Mockito.when(fakeBookRepository.findAll()).thenReturn(books);

        assertEquals(2,bookService.findNumberOfBooks());
    }
}
