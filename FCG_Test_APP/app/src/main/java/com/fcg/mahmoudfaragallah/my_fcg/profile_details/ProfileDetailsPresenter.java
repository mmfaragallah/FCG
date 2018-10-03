package com.fcg.mahmoudfaragallah.my_fcg.profile_details;

import com.fcg.mahmoudfaragallah.my_fcg.backend.ProfilesService;
import com.fcg.mahmoudfaragallah.my_fcg.model.data_model.ProfileObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mahmoud
 */

public class ProfileDetailsPresenter implements ProfileDetailsContract.Presenter {

    //region constants
    public static final String PROFILE_ID = "PROFILE_ID";
    //endregion

    //region objects
    private int profileId;
    private ProfileDetailsContract.View profileDetailsView;
    private ProfilesService profilesService;
    //endregion

    //region constructors
    public ProfileDetailsPresenter(ProfileDetailsContract.View profileDetailsView, ProfilesService profilesService) {

        this.profileId = profileDetailsView.getProfileId();
        this.profilesService = profilesService;
        this.profileDetailsView = profileDetailsView;
    }
    //endregion

    //region presenter callbacks

    @Override
    public void getProfileDetails() {

        profileDetailsView.showProgressDialog();

        Call<ProfileObject> call = profilesService.getProfileDetails(profileId);

        call.enqueue(new Callback<ProfileObject>() {
            @Override
            public void onResponse(Call<ProfileObject> call, Response<ProfileObject> response) {

                profileDetailsView.dismissProgressDialog();

                if (response.isSuccessful()) {

                    ProfileObject profileObject = response.body();
                    if (profileObject != null) {

                        profileDetailsView.bindProfileName(profileObject.getFirstName() + " " + profileObject.getLastName());

                        if (profileObject.getProfilePicture() != null) {
                            profileDetailsView.bindProfileImage(profileObject.getProfilePicture());
                        }

                    } else {
                        profileDetailsView.noDetailsResults(profileId);
                    }

                } else {
                    profileDetailsView.noDetailsResults(profileId);
                }
            }

            @Override
            public void onFailure(Call<ProfileObject> call, Throwable t) {

                profileDetailsView.dismissProgressDialog();

                profileDetailsView.noDetailsResults(profileId);
            }
        });
    }
    //endregion
}