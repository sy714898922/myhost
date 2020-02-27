package priv.simon.consumer.Controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.simon.consumer.ExceptionUtil.MyException;
import priv.simon.consumer.ExceptionUtil.Result;
import priv.simon.consumer.ExceptionUtil.ResultUtil;

@RestController
public class ExceptionController {
    @RequestMapping("/exception")
    public Result exception(String name, String pwd) throws Exception {
        String realname="zhangsan";
        String realPwd="123";

        if(null!=name&&name.equals("xx")){
            throw new Exception("系统异常！");
        }
        if(StringUtils.isEmpty(name)||StringUtils.isEmpty(pwd)){
            throw new MyException("参数必须传！");
        }else if (!name.equals(realname)||!pwd.equals(realPwd)){
            throw new MyException("用户名或密码不正确！");
        }else if (name.equals("aa")){
            throw new MyException("成功",200);
        }
        String info="你好["+name+"]!";
        return ResultUtil.success(info);
    }
    @RequestMapping("/success")
    public Result success() throws Exception {
        return ResultUtil.success(200,"自定义消息");
    }
}
