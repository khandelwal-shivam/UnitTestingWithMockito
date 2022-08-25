package test.Unit_test_Without_Mockito.mock_test_double_example.Service;


import Unit_Testing_Without_Mockito.mock_test_double_example.Repository.BookRepository;
import org.junit.jupiter.api.Test;
import Unit_Testing_Without_Mockito.mock_test_double_example.Entity.Book;
import Unit_Testing_Without_Mockito.mock_test_double_example.Service.BookService;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import test.Unit_test_Without_Mockito.mock_test_double_example.Repository.BookRepositoryMock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MockTest {

    @Test
    public void demoMock() {
        BookRepositoryMock bookRepositoryMock = new BookRepositoryMock();
        BookService bookService = new BookService(bookRepositoryMock);
        bookService.addBook(new Book("1234","Mockito In Action",250, LocalDate.now()));
        bookService.addBook(new Book("1235","Junit5 In Action",200, LocalDate.now()));
        bookRepositoryMock.verify(new Book("1235","Junit5 In Action",200, LocalDate.now()),1);
    }

    @Test
    public void demoMockWithMockito() {
        BookRepository bookRepositoryMock = Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(bookRepositoryMock);
        Book book1 = new Book("1234","Mockito In Action",250, LocalDate.now()); // return
        Book book2 = new Book("1235","Junit5 In Action",200, LocalDate.now()); // save will be called
//        ArrayList<Book> books = new ArrayList<>(List.of(book1,book2));
        bookService.addBook(book1);
        bookService.addBook(book2);
        Mockito.verify(bookRepositoryMock).save(book2); // will fail for book1
        Mockito.verify(bookRepositoryMock,Mockito.times(1)).save(book2);
        Mockito.verify(bookRepositoryMock,Mockito.times(0)).save(book1);

    }
}
