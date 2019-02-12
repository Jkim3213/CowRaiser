package io.github.jkim3213.cowraiser;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class PWResetActivity extends AppCompatActivity {

    private static final String TAG = "PWResetActivity";

    private EditText email;
    private Button button;
    private String strEmail;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwreset);

        //Find and assign UI elements
        email = findViewById(R.id.pwResetEmail);
        button = findViewById(R.id.pwResetButton);

        //Get instance of FirebaseAuth
        auth = FirebaseAuth.getInstance();

        //On button click, check if email is null, send PW reset email.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email != null) {
                    strEmail = email.getText().toString();
                    auth.sendPasswordResetEmail(strEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Log.d(TAG, "Email sent.");
                            }
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter an email", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
