package io.github.jkim3213.cowraiser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class ChallengeActivity extends AppCompatActivity {

    protected TextView challengeTitle;
    protected TextView challengeDesc;
    protected EditText entryEditText;
    protected Button logButton;
    public int ecoDollars = 0;
    int carbonLbs = 0;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);
        mDatabase = FirebaseDatabase.getInstance().getReference("Users/" + UserProfile.UID);
        challengeTitle = findViewById(R.id.challengeTitle);
        challengeDesc = findViewById(R.id.challengeDesc);
        entryEditText = (EditText) findViewById(R.id.entryEditText);
        logButton = findViewById(R.id.logButton);
        logButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                UserProfile.carbonLbs += carbonLbs;
                UserProfile.ecoDollars += ecoDollars;
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat calFormat = new SimpleDateFormat("MM/dd/yyyy, HH:mm:ss");
                String strTime = calFormat.format(calendar.getTime());
                JournalEntry entry = new JournalEntry(challengeTitle.getText().toString(),strTime,entryEditText.getText().toString(),ecoDollars,carbonLbs);
                UserProfile.journalEntryList.add(entry);
                mDatabase.setValue(new UserProfile());
                String complete = getString(R.string.challenge_complete_toast, ecoDollars);
                Toast.makeText(getApplicationContext(), complete, Toast.LENGTH_LONG).show();
                finish();
            }
        });


    }


}
