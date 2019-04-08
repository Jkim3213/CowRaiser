package io.github.jkim3213.cowraiser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
    public int baseEcoDollars = 0;
    int carbonLbs = 0;
    private DatabaseReference mDatabase;
    private int compostMulti = (UserProfile.curLevels.get("c") == null) ? 1 : UserProfile.curLevels.get("c") + 1;
    private int calculatedEco = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        //Get database instance
        mDatabase = FirebaseDatabase.getInstance().getReference("Users/" + UserProfile.UID);
        challengeTitle = findViewById(R.id.challengeTitle);
        challengeDesc = findViewById(R.id.challengeDesc);
        entryEditText = (EditText) findViewById(R.id.entryEditText);
        logButton = findViewById(R.id.logButton);

        //Update user data
        logButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("CHALLENGE", "compostMulti " + compostMulti);
                Log.d("CHALLENGE", "baseEcoDollars " + baseEcoDollars);
                calculatedEco = baseEcoDollars * compostMulti; //The formula
                UserProfile.carbonLbs += carbonLbs;
                UserProfile.ecoDollars += calculatedEco;

                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat calFormat = new SimpleDateFormat("MM/dd/yyyy, HH:mm:ss");
                String strTime = calFormat.format(calendar.getTime());

                JournalEntry entry = new JournalEntry(challengeTitle.getText().toString(),strTime,entryEditText.getText().toString(), calculatedEco,carbonLbs);
                UserProfile.journalEntryList.add(entry);
                mDatabase.setValue(new UserProfile());
                String complete = getString(R.string.challenge_complete_toast, calculatedEco);
                Toast.makeText(getApplicationContext(), complete, Toast.LENGTH_LONG).show();
                finish();
            }
        });


    }


}
