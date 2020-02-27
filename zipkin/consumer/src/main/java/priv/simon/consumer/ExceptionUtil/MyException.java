package priv.simon.consumer.ExceptionUtil;

public class MyException extends RuntimeException {

    private Integer code;

    public MyException(String msg) {
        super(msg);
    }
    public MyException(String msg,Integer code) {
        super(msg);
        this.code = code;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
