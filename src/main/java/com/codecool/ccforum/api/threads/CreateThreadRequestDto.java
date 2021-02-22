package com.codecool.ccforum.api.threads;

public class CreateThreadRequestDto {

    private String title;
    private String desc;

    public CreateThreadRequestDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
