package test.spies.service;

import Spies.Service.BookManager;
import Spies.Service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import Spies.Entity.Book;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class BookManagerTest {

    @InjectMocks
    BookManager bookManager;

    @Spy
    private BookService bookService;

    @Test
    public void testMockitoSpy() {
        // we can create spy using this traditional way or via annotations.
        /*
        BookService bookService = Mockito.spy(BookService.class);
        BookManager bookManager = new BookManager(bookService);
        */
        /*
        * We need to mock findBook because it is communicating with database or it is not implemented.
        * We need to call getAppliedDiscount to calculate the discountedPrice
        * */
        Book book1 = new Book(null,"Mockito In Action",500, LocalDate.now());
        doReturn(book1).when(bookService).findBook("1234");
        int actualDiscount = bookManager.applyDiscountOnBooks("1234",10);
        assertEquals(450,actualDiscount);
    }
}
