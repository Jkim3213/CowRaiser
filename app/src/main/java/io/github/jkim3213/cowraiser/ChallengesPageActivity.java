package io.github.jkim3213.cowraiser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ChallengesPageActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ChallengeAdapter adapter;
    private ArrayList<Challenge> challengeArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challengespage);

        recyclerView = (RecyclerView) findViewById(R.id.challengesRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        challengeArrayList = new ArrayList<>();
        adapter = new ChallengeAdapter(this, challengeArrayList);
        recyclerView.setAdapter(adapter);

        createListData();

    }

    private void createListData() {
        Challenge challenge = new Challenge(getString(R.string.vegetarian_title), getString(R.string.vegetarian_desc), 6, 12 );
        challengeArrayList.add(challenge);

        adapter.notifyDataSetChanged();

        challenge = new Challenge(getString(R.string.light_title), getString(R.string.light_desc), 6, 12 );
        challengeArrayList.add(challenge);

        adapter.notifyDataSetChanged();

        challenge = new Challenge(getString(R.string.altertransport_title), getString(R.string.altertransport_desc), 6, 12 );
        challengeArrayList.add(challenge);

        adapter.notifyDataSetChanged();

        challenge = new Challenge(getString(R.string.shower_title), getString(R.string.shower_desc), 6, 12 );
        challengeArrayList.add(challenge);

        adapter.notifyDataSetChanged();

        challenge = new Challenge(getString(R.string.rice_title), getString(R.string.rice_desc), 6, 12 );
        challengeArrayList.add(challenge);

        adapter.notifyDataSetChanged();

        challenge = new Challenge(getString(R.string.publtransport_title), getString(R.string.publtransport_desc), 6, 12 );
        challengeArrayList.add(challenge);

        adapter.notifyDataSetChanged();

    }
}