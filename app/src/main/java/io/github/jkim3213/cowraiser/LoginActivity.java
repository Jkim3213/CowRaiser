package io.github.jkim3213.cowraiser;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    Button btnLogin;
    AutoCompleteTextView userName;
    EditText password;

    private TextView signup;

    private FirebaseAuth mAuth;
    private ProgressDialog pDialog;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mAuth = FirebaseAuth.getInstance();
        pDialog = new ProgressDialog(this);


        btnLogin = findViewById(R.id.loginButton);
        userName = findViewById(R.id.loginEmailField);
        password = findViewById(R.id.loginPasswordField);

        signup = findViewById(R.id.signup_text);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), RegistrationActivity.class));

            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mEmail = userName.getText().toString().trim();
                String mPass = password.getText().toString().trim();

                if (TextUtils.isEmpty(mEmail)) {

                    userName.setError("username is required.");
                    return;
                }
                if (TextUtils.isEmpty(mPass)) {

                    password.setError("Password is required.");
                    return;

                }



                pDialog.setMessage("Loading....");
                pDialog.show();

                mAuth.signInWithEmailAndPassword(mEmail, mPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            mDatabase = FirebaseDatabase.getInstance().getReference("Users/" + mAuth.getCurrentUser().getUid());
                            mDatabase.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    UserProfile post = dataSnapshot.getValue(UserProfile.class);
                                    post.setUser();
                                    UserProfile.UID = mAuth.getCurrentUser().getUid();
                                    Log.i("LOGIN", post.toString());
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {
                                    System.out.println("The read failed: " + databaseError.getCode());
                                }
                            });
                            Toast.makeText(getApplicationContext(),"Login Successful", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            pDialog.dismiss();
                        } else {

                            Toast.makeText(getApplicationContext(), "help is on the way", Toast.LENGTH_SHORT);
                            pDialog.dismiss();
                        }

                    }
                });
            }
        });


    }

}

    //sign up




