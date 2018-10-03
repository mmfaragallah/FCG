package com.fcg.mahmoudfaragallah.my_fcg.model.data_model;

import com.google.gson.annotations.SerializedName;

public class ProfileObject {

    @SerializedName("id")
    private int id;

    @SerializedName("profile_picture")
    private String profilePicture;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
