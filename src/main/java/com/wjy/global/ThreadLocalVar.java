package com.wjy.global;

/**
 * 定义线程变量
 *
 * @author ybxxszl
 * @date 2018年10月7日
 * @description TODO
 */
public class ThreadLocalVar {

    private String author_id;

    private String token;

    public ThreadLocalVar() {
        super();
    }

    public ThreadLocalVar(String author_id, String token) {
        super();
        this.author_id = author_id;
        this.token = token;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "ThreadLocalVar{" +
                "author_id='" + author_id + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

}
