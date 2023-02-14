package com.merah.bawang.view.homescreen.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.merah.bawang.model.PostRVItem;
import com.merah.bawang.R;
import com.merah.bawang.viewmodel.homescreen.fragments.ViewModelPostFragment;
import com.merah.bawang.viewmodel.recyclerviewposts.PostAdapter;

import java.util.ArrayList;

public class PostsFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<PostRVItem> postRVItems = new ArrayList<>();
    ViewModelPostFragment viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_posts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        PostAdapter adapter = new PostAdapter(getContext(), postRVItems);
        recyclerView.setAdapter(adapter);

        viewModel = new ViewModelProvider(this).get(ViewModelPostFragment.class);
        viewModel.getAllPosts().observe(getViewLifecycleOwner(), adapter::updatePosts);
    }
}