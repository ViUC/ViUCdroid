package com.example.dieuvainmusaghi.viuc.model;

import java.io.Serializable;

/**
 * Created by Mich3lo on 5/11/16.
 */
public class Video implements Serializable {

    public String getID() {
        return ID;
    }



    private String ID;

    public String getVideoID() {
        return VideoID;
    }
    public String getTitle() {
        return Title;
    }
    public String getDescription() {
        return Description;
    }
    public String getUsername() {
        return Username;
    }
    public String getCategory() {return Category;}


/*
    public void setID(String ID) {
        this.ID = ID;
    }
    public void setVideoID(String videoID) {
        VideoID = videoID;
    }
    public void setTitle(String title) {
        Title = title;
    }
    public void setDescription(String description) {
        Description = description;
    }
    public void setUsername(String username) {
        Username = username;
    }
    public void setCategory(String category) {Category = category;}

    */

    private String VideoID;
    private String Title;
    private String Description;
    private String Username;
    private String Category;



    public Video(){
        //Null constructor
    }

    public Video(String VideoID, String Title, String Description){
        this.VideoID=VideoID;
        this.Title=Title;
        this.Description=Description;
    }

/*    public Video(String username){
        this.Username=username;
    }*/

    public Video(String category){
        this.Category=category;
    }


}
