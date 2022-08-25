package test.Unit_test_Without_Mockito.mock_test_double_example.Repository;

import Unit_Testing_Without_Mockito.mock_test_double_example.Entity.Book;
import Unit_Testing_Without_Mockito.mock_test_double_example.Repository.BookRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class BookRepositoryMock implements BookRepository {
    private int saveCalled = 0;
    private Book lastAddedBook = null;
    @Override
    public void save(Book book) {
        ++saveCalled;
        lastAddedBook = book;
    }

    public void verify(Book book, int times) {
        assertEquals(times,saveCalled);
        assertEquals(book.getBookId(),lastAddedBook.getBookId());
    }
}
