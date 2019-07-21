package com.example.assignment_2_04_54.dummy.content;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Content {
    private String contentName;
    private String description;
    private int myImageList;


    public Content (
            String contentName,
            String description,
            int myImageList) {
        this.contentName = contentName;
        this.myImageList = myImageList;
        this.description = description;
    }

    public String getContent() {
        return contentName;
    }

    public String getDescription() {
        return description;
    }

    public int getMyImageList() {return myImageList; }
}
