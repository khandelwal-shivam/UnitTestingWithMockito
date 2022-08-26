package test.annotation_support;

import annotation_support.Entity.Book;
import annotation_support.Repository.BookRepository;
import annotation_support.Service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AnnotationTest {

    @Mock
    BookRepository bookRepository;

    @InjectMocks
    BookService bookService;

    @Test
    public void demoCreateMocksUsingAnnotations() {
        ArrayList<Book> books = new ArrayList<>(List.of(
                new Book("1234","Mockito In Action",500, LocalDate.now()),
                new Book("1235","Junit5 In Action",400, LocalDate.now())
        ));
        Mockito.when(bookRepository.findNewBooks(7)).thenReturn(books);
        List<Book> booksWithAppliedDiscount = bookService.getNewBookWithAppliedDiscount(10,7);
        assertEquals(2,booksWithAppliedDiscount.size());
        assertEquals(450,booksWithAppliedDiscount.get(0).getPrice());
        assertEquals(360,booksWithAppliedDiscount.get(1).getPrice());
    }
}
