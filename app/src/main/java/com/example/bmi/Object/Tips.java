package com.example.bmi.Object;

public class Tips {
    String title;
    Integer image;
    String decs;

    public Tips(String title, Integer image, String decs) {
        this.title = title;
        this.image = image;
        this.decs = decs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getDecs() {
        return decs;
    }

    public void setDecs(String decs) {
        this.decs = decs;
    }
}
