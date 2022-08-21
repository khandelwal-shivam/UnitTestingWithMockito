package test.stub_test_double_example.Service;

import stub_test_double_example.Entity.Book;
import stub_test_double_example.Repository.BookRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryStub implements BookRepository {

    @Override
    public List<Book> findNewBooks(int days) {
        List <Book> newBooks = new ArrayList<>();
        newBooks.add(new Book("1234","Mockito In Action",500, LocalDate.now()));
        newBooks.add(new Book("1235","Junit5 In Action",400, LocalDate.now()));
        return newBooks;
    }
}
