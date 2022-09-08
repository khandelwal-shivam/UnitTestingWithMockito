package Behavior_Verification.Service;

import Behavior_Verification.Entity.Book;
import Behavior_Verification.Repository.BookRepository;
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

    public void addBook(Book book) {
        if(book.getPrice()<=500) {
            return;
        }
        bookRepository.save(book);
    }
}
