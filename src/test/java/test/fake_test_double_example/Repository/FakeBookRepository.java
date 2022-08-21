package test.fake_test_double_example.Repository;

import fake_test_double_example.Entity.Book;
import fake_test_double_example.Repository.BookRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeBookRepository implements BookRepository {
    // here we will create a fake database using either list or hashmap
    Map<String, Book> bookStore = new HashMap<>();
    @Override
    public void save(Book book) {
        bookStore.put(book.getBookId(),book);
    }

    @Override
    public Collection<Book> findAll() {
        return bookStore.values();
    }
}
