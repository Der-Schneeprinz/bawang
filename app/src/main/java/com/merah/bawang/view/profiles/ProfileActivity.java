package com.merah.bawang.view.profiles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.merah.bawang.R;
import com.merah.bawang.model.OrganizationRVItem;
import com.merah.bawang.viewmodel.profilefragment.ViewModelProfileSelf;
import com.merah.bawang.viewmodel.recyclervieworganizations.OrgsAdapter;
import com.merah.bawang.viewmodel.recyclervieworganizations.ViewModelOrgs;

import java.util.ArrayList;
import java.util.Objects;

public class ProfileActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private final ArrayList<OrganizationRVItem> organizationRVItems = new ArrayList<>();
    private ViewModelOrgs viewModelOrgs;
    private ViewModelProfileSelf viewModelProfileSelf;

    private ProgressBar progressBar;
    private ImageView ivProfile;
    private TextView tvProfileName;
    private TextView tvProfileEmail;
    private TextView tvSex;
    private TextView tvDate;
    private TextView tvStudentID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // MASTHEAD / PROFILE DETAILS
        View mastInclude = findViewById(R.id.conMasthead);

        ImageButton ibEdit = mastInclude.findViewById(R.id.ibEdit);
        ibEdit.setVisibility(View.INVISIBLE);

        ivProfile = mastInclude.findViewById(R.id.ivProfile);
        tvProfileName = mastInclude.findViewById(R.id.tvProfileName);
        tvProfileEmail = mastInclude.findViewById(R.id.tvProfileEmail);
        tvSex = mastInclude.findViewById(R.id.tvSex);
        tvDate = mastInclude.findViewById(R.id.tvDate);
        tvStudentID = mastInclude.findViewById(R.id.tvStudentID);

        viewModelProfileSelf = new ViewModelProvider(this).get(ViewModelProfileSelf.class);
        viewModelProfileSelf.getProfile().observe(this, userSelfProfileItem -> {
            ivProfile.setImageDrawable(ContextCompat.getDrawable(this,
                    Objects.requireNonNull(viewModelProfileSelf.getProfile().getValue()).getProfile()));
            tvProfileName.setText(Objects.requireNonNull(viewModelProfileSelf
                    .getProfile().getValue()).getFullName());
            tvProfileEmail.setText(viewModelProfileSelf.getProfile().getValue().getEmail());
            tvSex.setText(viewModelProfileSelf.getProfile().getValue().getSex());
            tvDate.setText(viewModelProfileSelf.getProfile().getValue().getBirthdate());
            tvStudentID.setText(viewModelProfileSelf.getProfile().getValue().getStudentNo());
        });

        View rvInclude = findViewById(R.id.conAffiliates);

        // HIDES THE ORG SETTINGS BUTTON
        ImageButton ibOrgSettings = rvInclude.findViewById(R.id.ibOrgSettings);
        ibOrgSettings.setVisibility(View.INVISIBLE);

        // RECYCLERVIEW
        progressBar = rvInclude.findViewById(R.id.progressBar);
        recyclerView = rvInclude.findViewById(R.id.recyclerView);

        OrgsAdapter adapter = new OrgsAdapter(this, organizationRVItems);

        viewModelOrgs = new ViewModelProvider(this).get(ViewModelOrgs.class);
        viewModelOrgs.getAllOrgs().observe(this, adapter::updateOrgs);
        viewModelOrgs.getIsUpdating().observe(this, aBoolean -> {
            if(aBoolean) {
                progressBar.setVisibility(View.VISIBLE);
            } else {
                progressBar.setVisibility(View.INVISIBLE);
                recyclerView.smoothScrollToPosition(Objects.requireNonNull(viewModelOrgs.getAllOrgs().getValue()).size()-1);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);

    }
}