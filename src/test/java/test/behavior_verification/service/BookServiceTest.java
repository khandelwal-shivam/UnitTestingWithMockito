package test.behavior_verification.service;

import Behavior_Verification.Repository.BookRepository;
import Behavior_Verification.Service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import Behavior_Verification.Entity.Book;

import java.time.LocalDate;


@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void testAddBook() {
        Book book = new Book(null,"Mockito In Action",500, LocalDate.now());
        Book book1 = new Book(null,"Mockito In Action",600, LocalDate.now());
        bookService.addBook(book);
        Mockito.verify(bookRepository).save(book);
        bookService.addBook(book1);
        Mockito.verify(bookRepository).save(book1);
    }

}
