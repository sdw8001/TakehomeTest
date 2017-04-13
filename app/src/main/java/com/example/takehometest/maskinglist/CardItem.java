package com.example.takehometest.maskinglist;

/**
 * Created by 서대원 on 2017-04-12.
 */

public class CardItem {
    private String comment;

    public CardItem(){
        comment = "";
    }
    public CardItem(String comment){
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
