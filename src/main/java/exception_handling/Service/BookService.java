package exception_handling.Service;

import exception_handling.Entity.Book;
import exception_handling.Exception.DatabaseCustomizedReadException;
import exception_handling.Exception.DatabaseCustomizedWriteException;
import exception_handling.Repository.BookRepository;

import java.sql.SQLException;
import java.util.List;

public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public int getTotalPriceOfBooks() {
        List<Book> books = null;
        try {
            books = bookRepository.findAllBooks();
        } catch (SQLException e) {
            //log the exception
            throw new DatabaseCustomizedReadException("Unable to read from database due to - "+e.getMessage());
        }
        return books.stream().map(book -> book.getPrice()).reduce(0,(price1,price2 )->price1+price2);
    }

    public void addBook(Book book) {
        try {
            bookRepository.save(book);
        } catch (SQLException e) {
            //log the exception
            throw new DatabaseCustomizedWriteException(" Unable to write in database due to - "+e.getMessage());
        }
    }
}
