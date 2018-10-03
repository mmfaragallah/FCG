package com.fcg.mahmoudfaragallah.my_fcg.profile_details;


/**
 * Created by Mahmoud
 */

public interface ProfileDetailsContract {

    interface Presenter {
        void getProfileDetails();
    }

    interface View {

        int getProfileId();

        void showProgressDialog();

        void dismissProgressDialog();

        void noDetailsResults(int profileId);

        void bindProfileImage(String profilePhotoUrl);

        void bindProfileName(String profileName);
    }
}
