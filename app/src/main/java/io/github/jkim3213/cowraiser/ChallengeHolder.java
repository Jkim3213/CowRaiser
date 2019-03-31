package io.github.jkim3213.cowraiser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ChallengeHolder extends RecyclerView.ViewHolder {

    private TextView txtTitle, txtDesc;
    private Activity context;

    public ChallengeHolder(View itemView, Activity context) {
        super(itemView);
        txtTitle = itemView.findViewById(R.id.itemTitle);
        txtDesc = itemView.findViewById(R.id.itemDesc);
        this.context = context;
    }

    public void setDetails(final Challenge challenge) {
        txtTitle.setText(challenge.getName());
        txtDesc.setText(challenge.getDescription());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                if (context.getString(R.string.vegetarian_title).equals(challenge.getName())) {
                    intent = new Intent(context, VegetarianChallenge.class);

                } else if (context.getString(R.string.light_title).equals(challenge.getName())) {
                    intent = new Intent(context, LightChallenge.class);

                } else if (context.getString(R.string.altertransport_title).equals(challenge.getName())) {
                    intent = new Intent(context, AltTransportChallenge.class);

                } else if (context.getString(R.string.shower_title).equals(challenge.getName())) {
                    intent = new Intent(context, ShowerChallenge.class);

                } else if (context.getString(R.string.rice_title).equals(challenge.getName())) {
                    intent = new Intent(context, RiceChallenge.class);

                } else if (context.getString(R.string.publtransport_title).equals(challenge.getName())) {
                    intent = new Intent(context, PublTransportChallenge.class);

                }
                context.startActivity(intent);
            }
        });
    }
}
