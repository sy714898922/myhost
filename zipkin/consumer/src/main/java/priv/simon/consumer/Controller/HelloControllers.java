package priv.simon.consumer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.simon.bean.Book;


@RestController
@RequestMapping("/Markbook")
public class HelloControllers {
    @Autowired
    private FeignService feignService;

    @GetMapping("/getBookByName/{id}")
    public Book getBookName(@PathVariable String id){
        return feignService.getBookByName(id);
    }

    @GetMapping("/test1")
    public int math(){
        int a=2;
        int b=0;
        int c=a/b;
        return c;
    }
}
