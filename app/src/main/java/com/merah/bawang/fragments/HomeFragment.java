package com.merah.bawang.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.merah.bawang.ItemPostContent;
import com.merah.bawang.R;
import com.merah.bawang.RecyclerViewAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<ItemPostContent> itemPostContent = new ArrayList<ItemPostContent>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpItemPostContent();

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), itemPostContent);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void setUpItemPostContent() {
        // conUsername
        String[] postUsername = getResources().getStringArray(R.array.saUsernames);
        String[] postOrg = getResources().getStringArray(R.array.saOrgs);
        for(int i = 0; i < postUsername.length;i++){
            itemPostContent.add(new ItemPostContent(
                    postUsername[i],
                    postOrg[i%2],
                    getResources().getString(R.string.postText),
                    getResources().getString(R.string.postTitle),
                    "0",
                    "0",
                    R.drawable.ic_baseline_account_circle_24
            ));
        }
    }
}