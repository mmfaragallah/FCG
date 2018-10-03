package com.fcg.mahmoudfaragallah.my_fcg.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.fcg.mahmoudfaragallah.my_fcg.R;
import com.fcg.mahmoudfaragallah.my_fcg.backend.ProfilesService;
import com.fcg.mahmoudfaragallah.my_fcg.backend.RetrofitHandler;
import com.fcg.mahmoudfaragallah.my_fcg.profile_details.ProfileDetailsContract;
import com.fcg.mahmoudfaragallah.my_fcg.profile_details.ProfileDetailsPresenter;
import com.fcg.mahmoudfaragallah.my_fcg.util.LogUtil;
import com.fcg.mahmoudfaragallah.my_fcg.util.ProgressDialogFragment;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProfileDetailsScreen extends AppCompatActivity implements ProfileDetailsContract.View {

    //region Constants
    private static final String className = ProfileDetailsScreen.class.getSimpleName();
    //endregion


    //region objects
    private ProfilesService profilesService;
    private ProgressDialogFragment progressDialog;
    private ProfileDetailsContract.Presenter presenter;
    //endregion


    //region screen views
    @BindView(R.id.profile_image)
    ImageView profileImage;
    //endregion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_details_screen);

        ButterKnife.bind(this);

        this.initializeObjects();
        this.initializeViews();
        this.loadData();
    }

    private void initializeObjects() {

        progressDialog = new ProgressDialogFragment();
        profilesService = RetrofitHandler.getInstance(this.getCacheDir()).createProfileService();

        presenter = new ProfileDetailsPresenter(this, profilesService);
    }

    private void initializeViews() {


    }

    private void loadData() {
        presenter.getProfileDetails();
    }


    @Override
    public int getProfileId() {
        return getIntent().getIntExtra(ProfileDetailsPresenter.PROFILE_ID, -1);
    }


    @Override
    public void showProgressDialog() {
        progressDialog.show(getSupportFragmentManager(), "tag");
    }

    @Override
    public void dismissProgressDialog() {
        progressDialog.dismiss();
    }


    @Override
    public void noDetailsResults(int profileId) {
        LogUtil.showToast(this, "There are no details record for profile id: " + profileId);
    }

    @Override
    public void bindProfileImage(String profilePhotoUrl) {

        Picasso.get()
                .load(profilePhotoUrl)
                .placeholder(R.drawable.image_loading_animation)
//                .error(R.drawable.user_placeholder_error)
                .into(profileImage);
    }

    @Override
    public void bindProfileName(String profileName) {
        setTitle(profileName);
    }
}
