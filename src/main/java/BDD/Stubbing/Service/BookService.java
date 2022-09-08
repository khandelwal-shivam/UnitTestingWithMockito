package BDD.Stubbing.Service;

import BDD.Stubbing.Entity.Book;
import BDD.Stubbing.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getNewBookWithAppliedDiscount(int discountRate, int days) {
        List<Book> newBooks = bookRepository.findNewBooks(days);
        return newBooks.stream()
                .map(book -> new Book(
                        book.getBookId(),
                        book.getTitle(),
                        (book.getPrice()*(100-discountRate))/100,
                        book.getPublishDate()))
                .collect(Collectors.toList());
    }
}
