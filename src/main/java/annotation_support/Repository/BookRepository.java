package annotation_support.Repository;

import annotation_support.Entity.Book;

import java.util.List;

public interface BookRepository {

    List<Book> findNewBooks(int days);
}
