package Unit_Testing_Without_Mockito.spy_test_double_example.Service;

import Unit_Testing_Without_Mockito.spy_test_double_example.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Unit_Testing_Without_Mockito.spy_test_double_example.Entity.Book;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

//    public int findNumberOfBooks() {
//        return bookRepository.findAll().size();
//    }

}
