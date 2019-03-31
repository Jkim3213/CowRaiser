package io.github.jkim3213.cowraiser;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class EntryAdapter extends RecyclerView.Adapter<EntryHolder> {

    private Context context;
    private ArrayList<JournalEntry> entries;
    public EntryAdapter(Context context, ArrayList<JournalEntry> entries) {
        this.context = context;
        this.entries = entries;
    }

    @Override
    public int getItemCount() {
        return entries.size();
    }

    @Override
    public EntryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.entry_row,parent, false);
        return new EntryHolder(view);
    }

    @Override
    public void onBindViewHolder(EntryHolder holder, int position) {
        JournalEntry entry = entries.get(position);
        holder.setDetails(entry);
    }
}
