package com.merah.bawang.view.homescreen.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.merah.bawang.R;
import com.merah.bawang.model.PostItem;

import java.util.ArrayList;

public class DiscoverFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<PostItem> postItems = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discover, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //setUpItemPostContent();

        //recyclerView = view.findViewById(R.id.recyclerView);
        //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //recyclerView.setHasFixedSize(true);
        //RecyclerViewAdapter adapter = new RecyclerViewAdapter(getActivity(), posts);
        //recyclerView.setAdapter(adapter);
        //adapter.notifyDataSetChanged();
    }


    private void setUpItemPostContent() {
        // conUsername
        String[] postUsername = getResources().getStringArray(R.array.saUsernames);
        String[] postOrg = getResources().getStringArray(R.array.saOrgs);
        for(int i = 0; i < postUsername.length;i++){
            postItems.add(new PostItem(
                    "",
                    postUsername[i],
                    postOrg[i%2],
                    getResources().getString(R.string.postText),
                    getResources().getString(R.string.postTitle),
                    0,
                    0,
                    R.drawable.ic_baseline_account_circle_24
            ));
        }
    }
}