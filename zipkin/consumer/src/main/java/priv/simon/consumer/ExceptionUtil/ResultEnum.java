package priv.simon.consumer.ExceptionUtil;

public enum ResultEnum {

    SUCCESS(200,"成功"),
    FAIL(100,"失败"),
    EXCEPTION(300,"系统异常"),
    NOTFOUND(404,"页面丢失，一会在来");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
