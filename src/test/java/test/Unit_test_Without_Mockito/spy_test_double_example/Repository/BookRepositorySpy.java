package test.Unit_test_Without_Mockito.spy_test_double_example.Repository;

import Unit_Testing_Without_Mockito.spy_test_double_example.Entity.Book;
import Unit_Testing_Without_Mockito.spy_test_double_example.Repository.BookRepository;

public class BookRepositorySpy implements BookRepository {
    private int saveCalled =0;
    private Book lastAddedBook = null;
    @Override
    public void save(Book book) {
        ++saveCalled;
        lastAddedBook = book;
    }

    public int timeCalled() {
        return saveCalled;
    }

    public boolean calledWith(Book book) {
        return lastAddedBook.getBookId().equals(book.getBookId());
    }
}
