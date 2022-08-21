package test.stub_test_double_example.Service;

import stub_test_double_example.Entity.Book;
import org.junit.jupiter.api.Test;
import stub_test_double_example.Repository.BookRepository;
import stub_test_double_example.Service.BookService;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
}
