package io.github.jkim3213.cowraiser;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class EntryHolder extends RecyclerView.ViewHolder {

    private TextView challengeName,time, entryText;
    private Context context;

    public EntryHolder(View itemView) {
        super(itemView);
        challengeName = itemView.findViewById(R.id.entryChallengeNameView);
        time = itemView.findViewById(R.id.entryDateView);
        entryText = itemView.findViewById(R.id.entryTextView);
        context = itemView.getContext();
    }

    public void setDetails(final JournalEntry journalEntry) {
        challengeName.setText(journalEntry.getChallengeName());
        time.setText(journalEntry.getTime());
        entryText.setText(journalEntry.getEntryText());

//        itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = null;
//                context.startActivity(intent);
//            }
//        });
    }
}
