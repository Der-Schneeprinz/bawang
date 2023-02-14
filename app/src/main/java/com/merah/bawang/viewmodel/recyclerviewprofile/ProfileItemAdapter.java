package com.merah.bawang.viewmodel.recyclerviewprofile;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.merah.bawang.R;
import com.merah.bawang.model.UserRVItem;

import java.util.ArrayList;

public class ProfileItemAdapter extends RecyclerView.Adapter<ProfileItemAdapter.ProfileItemHolder> {

    private static final String TAG = "ProfileItemAdapter";
    private Context context;
    private ArrayList<UserRVItem> userRVItems;

    public ProfileItemAdapter(Context context, ArrayList<UserRVItem> userRVItems) {
        this.context = context;
        this.userRVItems = userRVItems;
    }

    @NonNull
    @Override
    public ProfileItemAdapter.ProfileItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_profile_item, parent, false);
        return new ProfileItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileItemAdapter.ProfileItemHolder holder, int position) {
        holder.fullName.setText(userRVItems.get(position).getFullName());
    }

    @Override
    public int getItemCount() {
        return userRVItems.size();
    }

    public void updateProfileItems(ArrayList<UserRVItem> userRVItems) {
        Log.i(TAG, "updateProfileItems has been called.");
        this.userRVItems = userRVItems;
        notifyDataSetChanged();
    }

    class ProfileItemHolder extends RecyclerView.ViewHolder {

        private final ImageView profile;
        private final TextView fullName;

        public ProfileItemHolder(@NonNull View itemView) {
            super(itemView);
            profile = itemView.findViewById(R.id.searchProfile);
            fullName = itemView.findViewById(R.id.searchFullName);
        }
    }
}
