package com.example.dishy_app;

public class DataNotification {
    private String img;
    private String time;
    private String content;


    public DataNotification(String img, String time, String content) {
        this.img = img;
        this.time = time;
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
