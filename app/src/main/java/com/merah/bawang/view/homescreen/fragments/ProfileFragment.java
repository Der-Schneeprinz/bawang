package com.merah.bawang.view.homescreen.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.merah.bawang.R;
import com.merah.bawang.model.OrganizationRVItem;
import com.merah.bawang.model.UserSelfProfileItem;
import com.merah.bawang.view.bootup.LoginActivity;
import com.merah.bawang.view.profiles.ProfileActivity;
import com.merah.bawang.viewmodel.profilefragment.ViewModelProfileSelf;
import com.merah.bawang.viewmodel.recyclervieworganizations.OrgsAdapter;
import com.merah.bawang.viewmodel.recyclervieworganizations.ViewModelOrgs;

import java.util.ArrayList;
import java.util.Objects;

public class ProfileFragment extends Fragment {

    private RecyclerView recyclerView;
    private final ArrayList<OrganizationRVItem> organizationRVItems = new ArrayList<>();
    private ViewModelOrgs viewModelOrgs;
    private ViewModelProfileSelf viewModelProfileSelf;

    private ProgressBar progressBar;
    private ImageButton imageButton;
    private Button btnLogOut;
    private ImageView ivProfile;
    private TextView tvProfileName;
    private TextView tvProfileEmail;
    private TextView tvSex;
    private TextView tvDate;
    private TextView tvStudentID;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnLogOut = view.findViewById(R.id.btnLogout);
        btnLogOut.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        });

        View mastInclude = view.findViewById(R.id.conMasthead);

        ivProfile = mastInclude.findViewById(R.id.ivProfile);
        tvProfileName = mastInclude.findViewById(R.id.tvProfileName);
        tvProfileEmail = mastInclude.findViewById(R.id.tvProfileEmail);
        tvSex = mastInclude.findViewById(R.id.tvSex);
        tvDate = mastInclude.findViewById(R.id.tvDate);
        tvStudentID = mastInclude.findViewById(R.id.tvStudentID);

        View rvInclude = view.findViewById(R.id.conAffiliates);

        progressBar = rvInclude.findViewById(R.id.progressBar);
        recyclerView = rvInclude.findViewById(R.id.recyclerView);
        imageButton = rvInclude.findViewById(R.id.ibOrgSettings);

        imageButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ProfileActivity.class);
            startActivity(intent);
        });

        OrgsAdapter adapter = new OrgsAdapter(getContext(), organizationRVItems);

        viewModelOrgs = new ViewModelProvider(this).get(ViewModelOrgs.class);
        viewModelOrgs.getAllOrgs().observe(getViewLifecycleOwner(), adapter::updateOrgs);
        viewModelOrgs.getIsUpdating().observe(getViewLifecycleOwner(), aBoolean -> {
            if(aBoolean) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.INVISIBLE);
                recyclerView.smoothScrollToPosition(Objects.requireNonNull(viewModelOrgs.getAllOrgs().getValue()).size()-1);
            }
        });

        viewModelProfileSelf = new ViewModelProvider(this).get(ViewModelProfileSelf.class);
        viewModelProfileSelf.getProfile().observe(getViewLifecycleOwner(), userSelfProfileItem -> {
            //ivProfile.setImageDrawable(viewModelProfileSelf.getProfile().getValue().getProfile());
            tvProfileName.setText(Objects.requireNonNull(viewModelProfileSelf.getProfile().getValue()).getFullName());
            tvProfileEmail.setText(viewModelProfileSelf.getProfile().getValue().getEmail());
            tvSex.setText(viewModelProfileSelf.getProfile().getValue().getSex());
            tvDate.setText(viewModelProfileSelf.getProfile().getValue().getBirthdate());
            tvStudentID.setText(viewModelProfileSelf.getProfile().getValue().getStudentNo());
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
}