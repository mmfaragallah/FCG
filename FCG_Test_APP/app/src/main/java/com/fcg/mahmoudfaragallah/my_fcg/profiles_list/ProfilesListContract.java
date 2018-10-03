package com.fcg.mahmoudfaragallah.my_fcg.profiles_list;

import com.fcg.mahmoudfaragallah.my_fcg.model.data_model.ProfileObject;

import java.util.List;

/**
 * Created by Mahmoud
 */

public interface ProfilesListContract {

    interface Presenter {
        void getProfiles();
    }

    interface View {

        void onProfileClick(int profileId);

        void setProfilesList(List<ProfileObject> profiles);

        void showProgressDialog();

        void dismissProgressDialog();
    }

    interface Router {
        void goToProfileDetailsScreen(int profileId);
    }
}
