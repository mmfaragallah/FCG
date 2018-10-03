package com.fcg.mahmoudfaragallah.my_fcg.profiles_list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fcg.mahmoudfaragallah.my_fcg.R;
import com.fcg.mahmoudfaragallah.my_fcg.model.data_model.ProfileObject;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mahmoud
 */

public class ProfilesListAdapter extends RecyclerView.Adapter<ProfilesListAdapter.ViewHolder> implements View.OnClickListener {

    //region objects
    private ProfilesListContract.View profilesListView;
    private List<ProfileObject> profilesList;
    //endregion

    public ProfilesListAdapter(ProfilesListContract.View profilesListView) {
        this.profilesList = new ArrayList<>();
        this.profilesListView = profilesListView;
    }

    /**
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ProfilesListAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {

        // create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_item_layout, parent, false);

        view.setOnClickListener(this);

        return new ViewHolder(view);
    }

    /**
     * @param viewHolder
     * @param position   the position of the item to be drawn
     */
    @Override
    public void onBindViewHolder(ProfilesListAdapter.ViewHolder viewHolder, int position) {

        ProfileObject profile = profilesList.get(position);

        Picasso.get()
                .load(profile.getProfilePicture())
                .placeholder(R.drawable.image_loading_animation)
//                .error(R.drawable.user_placeholder_error)
                .into(viewHolder.profileImage);

//        viewHolder.profileImage.setText(profile.getProfilePicture());

        viewHolder.itemView.setTag(profile.getId());
    }

    /**
     * @param view
     */
    @Override
    public void onClick(View view) {

        String profileId = (String) view.getTag();
        profilesListView.onProfileClick(profileId);
    }

    /**
     * ViewHolder class
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public View itemView;

        @BindView(R.id.profile_image)
        ImageView profileImage;

        /**
         * @param itemView
         */
        public ViewHolder(View itemView) {
            super(itemView);

            this.itemView = itemView;

            ButterKnife.bind(this, itemView);
        }
    }

    /**
     * @param profiles
     */
    public void updateProfilesList(List<ProfileObject> profiles) {
        this.profilesList = profiles;
        notifyDataSetChanged();
    }

    /**
     * @return
     */
    @Override
    public int getItemCount() {
        return profilesList.size();
    }
}