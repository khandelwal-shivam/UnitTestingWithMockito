package test.Unit_test_Without_Mockito.stub_test_double_example.Service;

import Unit_Testing_Without_Mockito.stub_test_double_example.Entity.Book;
import org.junit.jupiter.api.Test;
import Unit_Testing_Without_Mockito.stub_test_double_example.Repository.BookRepository;
import Unit_Testing_Without_Mockito.stub_test_double_example.Service.BookService;
import org.mockito.Mockito;
import test.Unit_test_Without_Mockito.stub_test_double_example.Repository.BookRepositoryStub;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class StubTest {
    @Test
    public void demoStub() {
        BookRepository bookRepository = new BookRepositoryStub();
        BookService bookService = new BookService(bookRepository);
        List<Book> booksWithAppliedDiscount = bookService.getNewBookWithAppliedDiscount(10,7);
        assertEquals(2,booksWithAppliedDiscount.size());
        assertEquals(450,booksWithAppliedDiscount.get(0).getPrice());
        assertEquals(360,booksWithAppliedDiscount.get(1).getPrice());
    }

    @Test
    public void demoStubWithMockito() {
        BookRepository bookRepository = Mockito.mock(BookRepository.class);
        BookService bookService = new BookService(bookRepository);
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
