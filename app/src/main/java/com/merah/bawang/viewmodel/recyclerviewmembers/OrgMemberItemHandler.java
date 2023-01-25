package com.merah.bawang.viewmodel.recyclerviewmembers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.merah.bawang.R;
import com.merah.bawang.model.Member;

import java.util.ArrayList;

public class OrgMemberItemHandler extends RecyclerView.Adapter<OrgMemberItemHandler.ViewHolder> {

    Context context;
    ArrayList<Member> membersList;

    public OrgMemberItemHandler(Context context, ArrayList<Member> membersList) {
        this.context = context;
        this.membersList = membersList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@android.support.annotation.NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_member, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrgMemberItemHandler.ViewHolder holder, int position) {
        Member member = membersList.get(position);
        holder.fullName.setText(member.getFullName());
        holder.profile.setImageResource(member.getProfilePicture());
    }

    @Override
    public int getItemCount() {
        return  membersList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView profile;
        TextView fullName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profile = itemView.findViewById(R.id.ivProfile);
            fullName = itemView.findViewById(R.id.tvUsername);
        }
    }
}
