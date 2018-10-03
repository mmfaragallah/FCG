package com.fcg.mahmoudfaragallah.my_fcg.backend;

import com.fcg.mahmoudfaragallah.my_fcg.model.data_model.ProfileObject;
import com.fcg.mahmoudfaragallah.my_fcg.model.responses.ProfilesAPIResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Mahmoud
 */

public interface ProfilesService {

    @GET("profiles")
    Call<List<ProfileObject>> getProfiles();

//    @GET("profiles/{profile_id}")
//    Call<DetailsAPIResponse> getProfileDetails(@Path("profile_id") String profileId);
}
