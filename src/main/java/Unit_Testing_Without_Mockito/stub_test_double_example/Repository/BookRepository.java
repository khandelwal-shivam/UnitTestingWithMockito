package Unit_Testing_Without_Mockito.stub_test_double_example.Repository;

import Unit_Testing_Without_Mockito.stub_test_double_example.Entity.Book;

import java.util.List;

public interface BookRepository {

    List<Book> findNewBooks(int days);
}
