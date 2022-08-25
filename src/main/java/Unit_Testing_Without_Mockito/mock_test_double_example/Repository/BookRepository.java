package Unit_Testing_Without_Mockito.mock_test_double_example.Repository;

import Unit_Testing_Without_Mockito.mock_test_double_example.Entity.Book;

public interface BookRepository {
    void save(Book book);
//    Collection<Book> findAll();
}
