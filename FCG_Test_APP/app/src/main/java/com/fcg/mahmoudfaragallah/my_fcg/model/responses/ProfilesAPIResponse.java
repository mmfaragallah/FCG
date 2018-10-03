package com.fcg.mahmoudfaragallah.my_fcg.model.responses;


import com.fcg.mahmoudfaragallah.my_fcg.model.data_model.ProfileObject;

import java.util.List;

public class ProfilesAPIResponse {

    private List<ProfileObject> profiles;

    public List<ProfileObject> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<ProfileObject> profiles) {
        this.profiles = profiles;
    }
}
