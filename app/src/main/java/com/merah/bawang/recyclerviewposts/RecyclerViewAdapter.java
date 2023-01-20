package com.merah.bawang.recyclerviewposts;

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

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder> {

    Context context;
    ArrayList<ItemPostContent> itemPostContent;

    public RecyclerViewAdapter(Context context, ArrayList<ItemPostContent> itemPostContent) {
        this.context = context;
        this.itemPostContent = itemPostContent;
    }

    /**
     * RecyclerView.ViewHolder onCreateViewHolder inflates the layout (Giving a look to the rows)
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public RecyclerViewAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_search_post, parent, false);
        return new ItemViewHolder(view);
    }

    /**
     * void onBindViewHolder binds the values to the views inflated through the
     * RecyclerView.ViewHolder as inflated in the layout based on the position of the RecyclerView
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ItemViewHolder holder, int position) {
        // conButtons
        holder.postUpvoteCount.setText(itemPostContent.get(0).getPostUpvotes());
        holder.postDownvoteCount.setText(itemPostContent.get(0).getPostDownvotes());
        // conUsername
        holder.postUsername.setText(itemPostContent.get(position).getPostUsername());
        holder.postOrg.setText(itemPostContent.get(position%2).getPostOrg());
        // parent
        holder.postText.setText(itemPostContent.get(0).getPostText());
        holder.postTitle.setText(itemPostContent.get(0).getPostTitle());
    }

    /**
     * for the item_search_post.xml layout
     * @return
     */
    @Override
    public int getItemCount() {
        return itemPostContent.size();
    }

    /**
     * gets all the views from item_search_post.xml file
     * similar to onCreateViewHolder
     */
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        // conButtons
        ImageButton postUpvote;
        ImageButton postDownvote;
        ImageButton postComment;
        TextView postUpvoteCount;
        TextView postDownvoteCount;
        // conUsername
        ImageView postProfile;
        TextView postUsername;
        TextView postInBetween;
        TextView postOrg;
        // parent
        TextView postTitle;
        TextView postText;

        public ItemViewHolder(@androidx.annotation.NonNull View itemView) {
            super(itemView);

            // conButtons
            postUpvote = itemView.findViewById(R.id.ibUpvote);
            postDownvote = itemView.findViewById(R.id.ibDownvote);
            postComment = itemView.findViewById(R.id.ibComment);
            postUpvoteCount = itemView.findViewById(R.id.tvUpvoteCounter);
            postDownvoteCount = itemView.findViewById(R.id.tvDownvoteCounter);
            // conUsername
            postProfile = itemView.findViewById(R.id.ivProfile);
            postUsername = itemView.findViewById(R.id.tvUsername);
            postInBetween = itemView.findViewById(R.id.tvIn);
            postOrg = itemView.findViewById(R.id.tvOrg);
            // parent
            postTitle = itemView.findViewById(R.id.tvTitle);
            postText = itemView.findViewById(R.id.tvPost);
        }
    }
}
