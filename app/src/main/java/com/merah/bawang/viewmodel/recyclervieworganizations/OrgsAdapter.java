package com.merah.bawang.viewmodel.recyclervieworganizations;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.merah.bawang.R;
import com.merah.bawang.model.OrganizationRVItem;

import java.util.ArrayList;

public class OrgsAdapter extends RecyclerView.Adapter<OrgsAdapter.OrgViewHolder> {

    private static final String TAG = "OrgsAdapter";
    private Context context;
    private ArrayList<OrganizationRVItem> organizationRVItems;

    public OrgsAdapter(Context context, ArrayList<OrganizationRVItem> organizationRVItems) {
        this.context = context;
        this.organizationRVItems = organizationRVItems;
    }

    @NonNull
    @Override
    public OrgsAdapter.OrgViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_organization_item, parent, false);
        return new OrgViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrgsAdapter.OrgViewHolder holder, int position) {
        holder.orgName.setText(organizationRVItems.get(position).getOrganizationName());
        holder.orgMemberType.setText(organizationRVItems.get(position).getMembershipType());
    }

    @Override
    public int getItemCount() {
        return organizationRVItems.size();
    }

    public void updateOrgs(ArrayList<OrganizationRVItem> organizationRVItems) {
        Log.i(TAG, "updateOrgs has been called.");
        this.organizationRVItems = organizationRVItems;
        notifyDataSetChanged();
    }

    public static class OrgViewHolder extends RecyclerView.ViewHolder {

        ImageView orgProfile;
        TextView orgName;
        TextView orgMemberType;

        public OrgViewHolder(@NonNull View itemView) {
            super(itemView);
            orgProfile = itemView.findViewById(R.id.ivProfile);
            orgName = itemView.findViewById(R.id.tvOrg);
            orgMemberType = itemView.findViewById(R.id.tvMembership);
        }
    }
}
