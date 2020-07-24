package priv.simon.consumer.Controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.simon.consumer.ExceptionUtil.MyException;
import priv.simon.consumer.ExceptionUtil.Result;
import priv.simon.consumer.ExceptionUtil.ResultUtil;

@RestController
public class ExceptionController {
    @GetMapping("/exception/{name}/{pwd}")
    public Result exception(@PathVariable("name") String name, @PathVariable("pwd") String pwd) throws Exception {
        String realname="zhangsan";
        String realPwd="123";
        String info=null;

        if(null!=name&&name.equals("xx")){
            throw new Exception("系统异常！");
        }
        if(StringUtils.isEmpty(name)||StringUtils.isEmpty(pwd)){
            throw new MyException("参数必须传！");
        }
        if (!name.equals(realname)||!pwd.equals(realPwd)){
            throw new MyException("用户名或密码不正确！");
        }else {
             info="你好["+name+"]!";
        }
        return ResultUtil.success(info);
    }
    @GetMapping("/success/{data}")
    public Result success(@PathVariable("data") String data) throws Exception {
        return ResultUtil.success(200,data);
    }
}
