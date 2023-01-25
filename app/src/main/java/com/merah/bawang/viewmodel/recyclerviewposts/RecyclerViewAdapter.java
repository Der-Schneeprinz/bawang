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

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.PostViewHolder> {

    Context context;
    ArrayList<PostItem> postItem;

    public RecyclerViewAdapter(Context context, ArrayList<PostItem> postItem) {
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
    public RecyclerViewAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_search_post, parent, false);
        return new PostViewHolder(view);
    }

    /**
     * void onBindViewHolder binds the values to the views inflated through the
     * RecyclerView.ViewHolder as inflated in the layout based on the position of the RecyclerView
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.PostViewHolder holder, int position) {
        // conButtons
        holder.postUpvoteCount.setText(Integer.toString(postItem.get(0).getUpvotes()));
        holder.postDownvoteCount.setText(Integer.toString(postItem.get(0).getDownvotes()));
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
        ImageButton postUpvote;
        ImageButton postDownvote;
        ImageButton postComment;
        TextView postUpvoteCount;
        TextView postDownvoteCount;
        // conUsername
        ImageView postProfile;
        TextView postFullName;
        TextView postInBetween;
        TextView postOrg;
        // parent
        TextView postTitle;
        TextView postText;

        public PostViewHolder(@androidx.annotation.NonNull View itemView) {
            super(itemView);

            // conButtons
            postUpvote = itemView.findViewById(R.id.ibUpvote);
            postDownvote = itemView.findViewById(R.id.ibDownvote);
            postComment = itemView.findViewById(R.id.ibComment);
            postUpvoteCount = itemView.findViewById(R.id.tvUpvoteCounter);
            postDownvoteCount = itemView.findViewById(R.id.tvDownvoteCounter);
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
