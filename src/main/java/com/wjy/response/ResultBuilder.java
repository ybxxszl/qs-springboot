package com.wjy.response;

public class ResultBuilder {

    // 状态码
    private Integer code;

    // 数据
    private Object data;

    // 消息
    private String msg;

    public ResultBuilder() {
        super();
    }

    public ResultBuilder(Integer code, Object data, String msg) {
        super();
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    /**
     * @param code
     * @param data
     * @param msg
     * @return Return
     * @date 2018年10月21日
     * @author ybxxszl
     * @description 建立自定义返回
     */
    public static ResultBuilder build(Integer code, Object data, String msg) {

        return new ResultBuilder(code, data, msg);

    }

    /**
     * @param data
     * @param msg
     * @return ReturnBuilder
     * @date 2018年10月21日
     * @author ybxxszl
     * @description 成功
     */
    public static ResultBuilder success(Object data, String msg) {

        return new ResultBuilder(200, data, msg);

    }

    /**
     * @param e
     * @return ReturnBuilder
     * @date 2019年1月7日
     * @author ybxxszl
     * @description 失败
     */
    public static ResultBuilder error(Exception e) {

        return new ResultBuilder(500, null, e.getMessage());

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Return [code=" + code + ", data=" + data + ", msg=" + msg + "]";
    }

}
