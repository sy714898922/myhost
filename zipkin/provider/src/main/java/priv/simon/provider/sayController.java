package priv.simon.provider;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.simon.bean.Book;

@RestController
@RequestMapping("/book")
public class sayController {

    @GetMapping ("/getBookByName/{id}")
    public Book getBookByName(@PathVariable String id) {

        Book book=null;
        Book book4 = new Book("#","其他书籍");
        book=book4;
        switch (id) {
            case "1":
                Book book1 = new Book("1", "格林童话");
                book= book1;
                break;
            case "2":
                Book book2 = new Book("2", "安徒生童话");
                book= book2;
                break;
            case "3":
                Book book3 = new Book("3", "黑格尔童话");
                book= book3;
                break;
        }
        return book;
    }
}
