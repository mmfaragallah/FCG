package com.fcg.mahmoudfaragallah.my_fcg.profiles_list;

import android.content.Context;
import android.content.Intent;

import com.fcg.mahmoudfaragallah.my_fcg.profile_details.ProfileDetailsPresenter;
import com.fcg.mahmoudfaragallah.my_fcg.ui.ProfileDetailsScreen;


/**
 * Created by Mahmoud
 */

public class ProfilesListRouter implements ProfilesListContract.Router {

    //region objects
    private Context context;
    //endregion

    //region constructors
    public ProfilesListRouter(Context context) {
        this.context = context;
    }
    //endregion

    //region Router callbacks
    @Override
    public void goToProfileDetailsScreen(int profileId) {

        Intent intent = new Intent(context, ProfileDetailsScreen.class);
        intent.putExtra(ProfileDetailsPresenter.PROFILE_ID, profileId);
        context.startActivity(intent);
    }
    //endregion
}