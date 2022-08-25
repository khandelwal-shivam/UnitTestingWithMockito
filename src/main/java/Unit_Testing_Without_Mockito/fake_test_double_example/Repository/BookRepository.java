package Unit_Testing_Without_Mockito.fake_test_double_example.Repository;

import Unit_Testing_Without_Mockito.fake_test_double_example.Entity.Book;

import java.util.Collection;

public interface BookRepository {
    void save(Book book);
    Collection<Book> findAll();
}
