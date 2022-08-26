package stubbing.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stubbing.Entity.Book;
import stubbing.Repository.BookRepository;

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
    public int calculateTotalCost(List<String> bookIds) {
        int totalCost = bookIds.stream()
                            .map(bookId -> bookRepository.findBookByBookId(bookId))
                            .map(book -> book.getPrice())
                            .reduce(0,(book1Price,book2Price) -> book1Price + book2Price);
        return totalCost;
    }
}
