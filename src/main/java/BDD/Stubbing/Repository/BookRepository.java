package BDD.Stubbing.Repository;

import BDD.Stubbing.Entity.Book;

import java.util.List;

public interface BookRepository {

    List<Book> findNewBooks(int days);
}
