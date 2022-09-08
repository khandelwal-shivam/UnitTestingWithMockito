package Spies.Service;

import Spies.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    public Book findBook(String bookId) {
        //code to bring book from db
//        return null; instead of throwing null what if we trow run time exception.
        throw new RuntimeException("Method not implemented");
    }

    public int getAppliedDiscount(Book book, int discountRate) {
        int price = book.getPrice();
        int newPrice = price - (price*discountRate/100);
        return newPrice;
    }
}
