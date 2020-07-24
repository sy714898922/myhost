package priv.simon.consumer.Controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import priv.simon.bean.Book;


@FeignClient(name = "provider")
public interface FeignService {

    @GetMapping("book/getBookByName/{id}")
    Book getBookByName(@PathVariable String id);
}
