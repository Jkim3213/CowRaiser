package io.github.jkim3213.cowraiser;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ChallengeAdapter extends RecyclerView.Adapter<ChallengeHolder> {

    private Context context;
    private ArrayList<Challenge> challenges;
    public ChallengeAdapter(Context context, ArrayList<Challenge> challenges) {
        this.context = context;
        this.challenges = challenges;
    }

    @Override
    public int getItemCount() {
        return challenges.size();
    }

    @Override
    public ChallengeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row,parent, false);
        return new ChallengeHolder(view);
    }

    @Override
    public void onBindViewHolder(ChallengeHolder holder, int position) {
        Challenge challenge = challenges.get(position);
        holder.setDetails(challenge);
    }
}