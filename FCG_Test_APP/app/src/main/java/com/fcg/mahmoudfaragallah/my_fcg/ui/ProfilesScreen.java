package com.fcg.mahmoudfaragallah.my_fcg.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.fcg.mahmoudfaragallah.my_fcg.R;
import com.fcg.mahmoudfaragallah.my_fcg.backend.ProfilesService;
import com.fcg.mahmoudfaragallah.my_fcg.backend.RetrofitHandler;
import com.fcg.mahmoudfaragallah.my_fcg.model.data_model.ProfileObject;
import com.fcg.mahmoudfaragallah.my_fcg.profiles_list.ProfilesListAdapter;
import com.fcg.mahmoudfaragallah.my_fcg.profiles_list.ProfilesListContract;
import com.fcg.mahmoudfaragallah.my_fcg.profiles_list.ProfilesListPresenter;

import com.fcg.mahmoudfaragallah.my_fcg.util.ProgressDialogFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ProfilesScreen extends AppCompatActivity implements ProfilesListContract.View {

    //region Constants
    private static final String className = ProfilesScreen.class.getSimpleName();
    //endregion


    //region objects
    private ProfilesService profilesService;
    private ProgressDialogFragment progressDialog;
    private ProfilesListAdapter listAdapter;
    private ProfilesListContract.Presenter presenter;
    //endregion


    //region screen views
    @BindView(R.id.profiles_list)
    RecyclerView profilesListView;
    //endregion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles_screen);

        ButterKnife.bind(this);

        this.initializeObjects();
        this.initializeViews();
        this.loadData();
    }

    private void initializeObjects() {

        progressDialog = new ProgressDialogFragment();
        profilesService = RetrofitHandler.getInstance(this.getCacheDir()).createProfileService();

        listAdapter = new ProfilesListAdapter(this);
        presenter = new ProfilesListPresenter(this, profilesService);
    }

    private void initializeViews() {

        setTitle(getString(R.string.profiles_screen_title));

        profilesListView.setHasFixedSize(true);
        profilesListView.setLayoutManager(new GridLayoutManager(this, 2));
        profilesListView.setAdapter(listAdapter);
    }

    private void loadData() {

        presenter.getProfiles();
        ;

    }


    @Override
    public void onProfileClick(String profileId) {

    }

    @Override
    public void setProfilesList(List<ProfileObject> profiles) {

        listAdapter.updateProfilesList(profiles);
    }

    @Override
    public void showProgressDialog() {
        progressDialog.show(getSupportFragmentManager(), "tag");
    }

    @Override
    public void dismissProgressDialog() {
        progressDialog.dismiss();
    }
}
