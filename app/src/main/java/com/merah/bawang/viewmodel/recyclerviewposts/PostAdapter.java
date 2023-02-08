package com.merah.bawang.viewmodel.recyclerviewposts;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.merah.bawang.R;
import com.merah.bawang.model.PostItem;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private Context context;
    private ArrayList<PostItem> postItem;

    public PostAdapter(Context context, ArrayList<PostItem> postItem) {
        this.context = context;
        this.postItem = postItem;
    }

    /**
     * RecyclerView.ViewHolder onCreateViewHolder inflates the layout (Giving a look to the rows)
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_post_noimage, parent, false);
        return new PostViewHolder(view);
    }

    /**
     * void onBindViewHolder binds the values to the views inflated through the
     * RecyclerView.ViewHolder as inflated in the layout based on the position of the RecyclerView
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull PostAdapter.PostViewHolder holder, int position) {
        // conButtons
        holder.postUpvoteCount.setText(Integer.toString(postItem.get(0).getVotes()));
        // conUsername
        holder.postFullName.setText(postItem.get(position).getFullName());
        holder.postOrg.setText(postItem.get(position%2).get_OID());
        // parent
        holder.postText.setText(postItem.get(0).getPostText());
        holder.postTitle.setText(postItem.get(0).getPostTitle());
    }

    /**
     * for the item_search_post.xml layout
     * @return
     */
    @Override
    public int getItemCount() {
        return postItem.size();
    }

    /**
     * gets all the views from item_search_post.xml file
     * similar to onCreateViewHolder
     */
    public static class PostViewHolder extends RecyclerView.ViewHolder {
        // conButtons
        private ImageButton postUpvote;
        private ImageButton postComment;
        private TextView postUpvoteCount;
        // conUsername
        private ImageView postProfile;
        private TextView postFullName;
        private TextView postInBetween;
        private TextView postOrg;
        // parent
        private TextView postTitle;
        private TextView postText;

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

    class ProgressViewHolder extends PostViewHolder {
        public ProgressViewHolder(View itemView) {
            super(itemView);
        }
    }
}