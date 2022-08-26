package test.stubbing.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import stubbing.Entity.Book;
import stubbing.Repository.BookRepository;
import stubbing.Service.BookService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void testCalculateTotalCostOfBooks() {
        ArrayList <String> bookIds = new ArrayList<>(List.of("1234","1234"));
        Book book1 = new Book("1234","Mockito In Action",500, LocalDate.now());
        Book book2 = new Book("1235","Junit5 In Action",400, LocalDate.now());
//        Mockito.when(bookRepository.findBookByBookId("1234")).thenReturn(book1);
//        Mockito.when(bookRepository.findBookByBookId("1235")).thenReturn(book2);

        Mockito.doReturn(book1).when(bookRepository).findBookByBookId("1234");
        Mockito.doReturn(book2).when(bookRepository).findBookByBookId("1235");
        int totalCost = bookService.calculateTotalCost(bookIds);
        assertEquals(1000,totalCost);
    }

}
