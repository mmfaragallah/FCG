package com.fcg.mahmoudfaragallah.my_fcg.profiles_list;

import com.fcg.mahmoudfaragallah.my_fcg.backend.ProfilesService;
import com.fcg.mahmoudfaragallah.my_fcg.model.data_model.ProfileObject;
import com.fcg.mahmoudfaragallah.my_fcg.ui.ProfilesListScreen;
import com.fcg.mahmoudfaragallah.my_fcg.util.LogUtil;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mahmoud
 */

public class ProfilesListPresenter implements ProfilesListContract.Presenter {


    //region Constants
    private static final String className = ProfilesListScreen.class.getSimpleName();
    //endregion


    // region objects
    private ProfilesService profilesService;
    private ProfilesListContract.View profilesListView;
    //endregion

    //region constructors
    public ProfilesListPresenter(ProfilesListContract.View profilesListView, ProfilesService profilesService) {

        this.profilesService = profilesService;
        this.profilesListView = profilesListView;
    }
    //endregion

    //region presenter callbacks
    @Override
    public void getProfiles() {

        profilesListView.showProgressDialog();

        Call<List<ProfileObject>> profilesAPICall = profilesService.getProfiles();

        profilesAPICall.enqueue(new Callback<List<ProfileObject>>() {
            @Override
            public void onResponse(Call<List<ProfileObject>> call, Response<List<ProfileObject>> response) {

                profilesListView.dismissProgressDialog();

                if (response.isSuccessful()) {
                    profilesListView.setProfilesList(response.body());
                } else {
                    profilesListView.noDataLoaded();
                }

            }

            @Override
            public void onFailure(Call<List<ProfileObject>> call, Throwable t) {

                profilesListView.dismissProgressDialog();

                LogUtil.error(className, t);

                profilesListView.noDataLoaded();
            }
        });
    }

    //endregion
}