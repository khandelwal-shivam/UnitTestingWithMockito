package test.BDD.Stubbing.Service;

import BDD.Stubbing.Repository.BookRepository;
import BDD.Stubbing.Service.BookService;
import BDD.Stubbing.Entity.Book;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class StubTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void testStubbingInTraditionalMockitoStyle() {

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

    @Test
    public void test_Given_NewBooks_When_GetNewBooksWithAppliedDiscountIsCalled_Then_BooksWithAppliedDiscountIsReturned() {
        //Arrange
        ArrayList<Book> books = new ArrayList<>(List.of(
                new Book("1234","Mockito In Action",500, LocalDate.now()),
                new Book("1235","Junit5 In Action",400, LocalDate.now())
        ));

        BDDMockito.given(bookRepository.findNewBooks(7)).willReturn(books);

        //Act
        List<Book> booksWithAppliedDiscount = bookService.getNewBookWithAppliedDiscount(10,7);

        //Assert
        //For Assertions in BDD we use BDDAssertions Class
        BDDAssertions.then(booksWithAppliedDiscount).isNotNull();
        BDDAssertions.then(booksWithAppliedDiscount.size()).isEqualTo(2);
        BDDAssertions.then(booksWithAppliedDiscount.get(0).getPrice()).isEqualTo(450);
        BDDAssertions.then(booksWithAppliedDiscount.get(1).getPrice()).isEqualTo(360);
    }
}
