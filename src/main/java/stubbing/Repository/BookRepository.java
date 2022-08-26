package stubbing.Repository;

import stubbing.Entity.Book;

import java.util.List;

public interface BookRepository {

    List<Book> findNewBooks(int days);
    Book findBookByBookId(String bookId);
}
