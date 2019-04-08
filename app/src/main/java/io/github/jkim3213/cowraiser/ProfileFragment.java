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
import java.util.LinkedList;
import java.util.List;

public class ProfileFragment extends Fragment {

    private RecyclerView recyclerView;
    private EntryAdapter adapter;
    private ArrayList<JournalEntry> entryArrayList;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getActivity().getApplicationContext();

        recyclerView = view.findViewById(R.id.journalEntryRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        entryArrayList = new ArrayList<>();
        adapter = new EntryAdapter(context, entryArrayList);
        recyclerView.setAdapter(adapter);
        createListData();
    }

    private void createListData() {
        ArrayList<JournalEntry> entry = UserProfile.getJournalEntryList();
        if (entry != null) {
            if (entry.size() > 0) {
                for (int i = entry.size(); i > 0; i--) {
                    //Found the culprit of breaking my code.
                    entryArrayList.add(entry.get(i - 1));
                    adapter.notifyDataSetChanged();
                }
            }
        }
    }
}
