package test.exception_handling.Service;

import exception_handling.Entity.Book;
import exception_handling.Exception.DatabaseCustomizedReadException;
import exception_handling.Exception.DatabaseCustomizedWriteException;
import exception_handling.Repository.BookRepository;
import exception_handling.Service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @Test
    public void testTotalPriceOfBook() throws SQLException {
        /* here bookRepository.findAllBooks has return type
        *
        * for other method which do not return anything. we can go via this way.
        * */
        Mockito.when(bookRepository.findAllBooks()).thenThrow(SQLException.class);
        assertThrows(DatabaseCustomizedReadException.class,() -> bookService.getTotalPriceOfBooks());
    }

    @Test
    public void testTotalPriceOfBook1() throws SQLException {
        /*
        * Another way of throwing exception
        * */
        Mockito.when(bookRepository.findAllBooks()).thenThrow(new SQLException("Database Not Available"));
        assertThrows(DatabaseCustomizedReadException.class,() -> bookService.getTotalPriceOfBooks());
    }

    @Test
    public void testAddBook() throws SQLException {
        Book book = new Book(null,"Mockito in Action",600, LocalDate.now());
        Mockito.doThrow(SQLException.class).when(bookRepository).save(book);
        assertThrows(DatabaseCustomizedWriteException.class,() -> bookService.addBook(book));
    }
}
