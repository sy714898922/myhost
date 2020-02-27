package priv.simon.provider;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import priv.simon.bean.Book;

@RestController
@RequestMapping({"/books"})
public class HelloController {
    Map<String, Book> BookMap = new HashMap();

    public HelloController() {
    }

    @ApiOperation("获取全部书籍信息")
    @RequestMapping(
            value = {" "},
            method = {RequestMethod.GET}
    )
    public List getBooks() {
        List<Book> list = new ArrayList(this.BookMap.values());
        return list;
    }

    @ApiOperation(
            value = "添加书籍",
            notes = "根据book创建书籍"
    )
    @ApiImplicitParam(
            name = "book",
            value = "书籍名字",
            required = true,
            dataType = "Book"
    )
    @RequestMapping(
            value = {""},
            method = {RequestMethod.POST}
    )
    public String PostBook(@RequestBody Book book) {
        this.BookMap.put(book.getId(), book);
        return "添加成功~~~";
    }

    @ApiOperation(
            value = "查询书籍",
            notes = "根据id查询书籍"
    )
    @ApiImplicitParam(
            name = "id",
            value = "书籍id",
            required = true,
            dataType = "Book"
    )
    @RequestMapping(
            value = {"/{id} "},
            method = {RequestMethod.GET}
    )
    public Book getNameById(@PathVariable String id) {
        Book book = (Book)this.BookMap.get(id);
        return book;
    }

    @ApiOperation(
            value = "跟新书籍",
            notes = "跟新书籍信息"
    )
    @ApiImplicitParams({@ApiImplicitParam(
            name = "id",
            value = "书籍id",
            required = true,
            paramType = "path",
            dataType = "String"
    ), @ApiImplicitParam(
            name = "book",
            value = "书籍实体",
            required = true,
            dataType = "Book"
    )})
    @RequestMapping(
            value = {"/{id}"},
            method = {RequestMethod.PUT}
    )
    public String upDateBook(@PathVariable String id, @RequestBody Book book) {
        Book b = (Book)this.BookMap.get(id);
        b.setId(book.getId());
        b.setName(book.getName());
        this.BookMap.put(id, b);
        return "更新成功";
    }

    @ApiOperation(
            value = "删除书籍",
            notes = "根据id删除书籍"
    )
    @ApiImplicitParam(
            name = "id",
            value = "书籍id",
            required = true,
            dataType = "String",
            paramType = "Path"
    )
    @RequestMapping(
            value = {"/{id}"},
            method = {RequestMethod.DELETE}
    )
    public String delBook(@PathVariable String id) {
        this.BookMap.remove(id);
        return "书籍id为" + id + "的书籍已经被删除";
    }
}