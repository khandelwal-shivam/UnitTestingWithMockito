package stub_test_double_example.Repository;

import stub_test_double_example.Entity.Book;

import java.util.Collection;
import java.util.List;

public interface BookRepository {

    List<Book> findNewBooks(int days);
}
