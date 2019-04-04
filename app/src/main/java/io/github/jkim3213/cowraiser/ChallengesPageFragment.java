package io.github.jkim3213.cowraiser;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ChallengesPageFragment extends Fragment {

    private RecyclerView recyclerView;
    private ChallengeAdapter adapter;
    private ArrayList<Challenge> challengeArrayList;
    private View view;
    private Context context;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_challengespage, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view = view;
        context = getActivity().getApplicationContext();

        recyclerView = (RecyclerView) view.findViewById(R.id.challengesRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        challengeArrayList = new ArrayList<>();
        adapter = new ChallengeAdapter(getActivity(), challengeArrayList);
        recyclerView.setAdapter(adapter);

        createListData();
    }

    private void createListData() {
        Challenge challenge = new Challenge(getString(R.string.vegetarian_title), getString(R.string.vegetarian_desc), 6, 12, R.drawable.releaf_icon_1 );
        challengeArrayList.add(challenge);

        adapter.notifyDataSetChanged();

        challenge = new Challenge(getString(R.string.light_title), getString(R.string.light_desc), 6, 12, R.drawable.releaf_icon_2);
        challengeArrayList.add(challenge);

        adapter.notifyDataSetChanged();

        challenge = new Challenge(getString(R.string.altertransport_title), getString(R.string.altertransport_desc), 6, 12, R.drawable.releaf_icon_3);
        challengeArrayList.add(challenge);

        adapter.notifyDataSetChanged();

        challenge = new Challenge(getString(R.string.shower_title), getString(R.string.shower_desc), 6, 12, R.drawable.releaf_icon_0);
        challengeArrayList.add(challenge);

        adapter.notifyDataSetChanged();

        challenge = new Challenge(getString(R.string.publtransport_title), getString(R.string.publtransport_desc), 6, 12, R.drawable.releaf_icon_4);
        challengeArrayList.add(challenge);

        adapter.notifyDataSetChanged();

    }
}