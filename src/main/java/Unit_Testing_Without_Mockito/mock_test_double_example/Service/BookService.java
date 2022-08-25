package Unit_Testing_Without_Mockito.mock_test_double_example.Service;

import Unit_Testing_Without_Mockito.mock_test_double_example.Repository.BookRepository;
import Unit_Testing_Without_Mockito.mock_test_double_example.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        if(book.getPrice()>220)return;
        bookRepository.save(book);
    }

//    public int findNumberOfBooks() {
//        return bookRepository.findAll().size();
//    }

}
