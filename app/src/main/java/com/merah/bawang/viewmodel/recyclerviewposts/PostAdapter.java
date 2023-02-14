package com.merah.bawang.viewmodel.recyclerviewposts;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.merah.bawang.R;
import com.merah.bawang.model.PostRVItem;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private static final String TAG = "PostAdapter";
    private Context context;
    private ArrayList<PostRVItem> postRVItems;

    public PostAdapter(Context context, ArrayList<PostRVItem> postRVItems) {
        this.context = context;
        this.postRVItems = postRVItems;
    }

    @NonNull
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_post_noimage, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.PostViewHolder holder, int position) {
        // conButtons
        holder.postUpvoteCount.setText(String.format(Integer.toString(postRVItems.get(0).getVotes())));
        // conUsername
        holder.postFullName.setText(postRVItems.get(position).getFullName());
        holder.postFullName.setSingleLine(true);
        holder.postOrg.setText(postRVItems.get(position%2).get_OID());
        holder.postOrg.setSingleLine(true);
        // parent
        holder.postText.setText(postRVItems.get(0).getPostText());
        holder.postTitle.setText(postRVItems.get(0).getPostTitle());
    }

    @Override
    public int getItemCount() {
        return postRVItems.size();
    }

    public void updatePosts(ArrayList<PostRVItem> postRVItems) {
        Log.i(TAG, "updatePosts has been called.");
        this.postRVItems = postRVItems;
        notifyDataSetChanged();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {

        // conButtons
        private final ImageButton postUpvote;
        private final ImageButton postComment;
        private final TextView postUpvoteCount;
        // conUsername
        private final ImageView postProfile;
        private final TextView postFullName;
        private final TextView postInBetween;
        private final TextView postOrg;
        // parent
        private final TextView postTitle;
        private final TextView postText;

        public PostViewHolder(@androidx.annotation.NonNull View itemView) {
            super(itemView);

            // conButtons
            postUpvote = itemView.findViewById(R.id.ibUpvote);
            postComment = itemView.findViewById(R.id.ibComment);
            postUpvoteCount = itemView.findViewById(R.id.tvUpvoteCounter);
            // conUsername
            postProfile = itemView.findViewById(R.id.ivProfile);
            postFullName = itemView.findViewById(R.id.tvUsername);
            postInBetween = itemView.findViewById(R.id.tvIn);
            postOrg = itemView.findViewById(R.id.tvOrg);
            // parent
            postTitle = itemView.findViewById(R.id.tvTitle);
            postText = itemView.findViewById(R.id.tvPost);
        }
    }
}
