package com.fcg.mahmoudfaragallah.my_fcg.backend;

import com.fcg.mahmoudfaragallah.my_fcg.model.data_model.ProfileObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Mahmoud
 */

public interface ProfilesService {

    @GET("profiles")
    Call<List<ProfileObject>> getProfiles();

    @GET("profiles/{profile_id}")
    Call<ProfileObject> getProfileDetails(@Path("profile_id") int profileId);
}
