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
import android.widget.ProgressBar;

import com.merah.bawang.model.PostRVItem;
import com.merah.bawang.R;
import com.merah.bawang.viewmodel.recyclerviewposts.viewmodelposts.ViewModelPostFragment;
import com.merah.bawang.viewmodel.recyclerviewposts.adapters.PostAdapter;

import java.util.ArrayList;
import java.util.Objects;

public class PostsFragment extends Fragment {

    private RecyclerView recyclerView;
    private final ArrayList<PostRVItem> postRVItems = new ArrayList<>();
    private ViewModelPostFragment viewModel;
    private ProgressBar progressBar;
    private PostAdapter adapter;

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

        progressBar = view.findViewById(R.id.progressBar);
        recyclerView = view.findViewById(R.id.recyclerView);
        adapter = new PostAdapter(getContext(), postRVItems);

        //viewModel = new ViewModelProvider(this).get(ViewModelPostFragment.class);
        viewModel = new ViewModelProvider(this).get(ViewModelPostFragment.class);
        viewModel.getAllPosts().observe(getViewLifecycleOwner(), adapter::updatePosts);
        viewModel.getIsUpdating().observe(getViewLifecycleOwner(), aBoolean -> {
            if(aBoolean) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.INVISIBLE);
                recyclerView.smoothScrollToPosition(Objects.requireNonNull(viewModel.getAllPosts().getValue()).size()-1);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }
}