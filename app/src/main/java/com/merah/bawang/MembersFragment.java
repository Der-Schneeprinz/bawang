package com.merah.bawang;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MembersFragment extends Fragment {

    private ArrayList<Member> membersList;
    private RecyclerView recyclerview;


    public MembersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpMembersItems();

        recyclerview = view.findViewById(R.id.recyclerView);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setHasFixedSize(true);
        OrgMemberItemHandler adapter = new OrgMemberItemHandler(getContext(), membersList);
        recyclerview.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private void setUpMembersItems() {
        membersList = new ArrayList<>();
        String[] orgUsername = getResources().getStringArray(R.array.saUsernames);
        for(int i = 0; i < orgUsername.length;i++){
            membersList.add(new Member(
                    R.drawable.ic_baseline_account_circle_24,
                    orgUsername[i]
            ));
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_members, container, false);
    }
}