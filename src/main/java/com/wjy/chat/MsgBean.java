package com.wjy.chat;

public class MsgBean {

    private String id;
    private String name;
    private String content;
    private String time;
    private Integer type;

    public MsgBean() {
        super();
    }

    public MsgBean(String id, String name, String time, Integer type) {
        super();
        this.id = id;
        this.name = name;
        this.time = time;
        this.type = type;
    }

    public MsgBean(String id, String name, String content, String time, Integer type) {
        super();
        this.id = id;
        this.name = name;
        this.content = content;
        this.time = time;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MsgBean [id=" + id + ", name=" + name + ", content=" + content + ", time=" + time + ", type=" + type
                + "]";
    }

}
