package io.github.jkim3213.cowraiser;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    Button btnLogin;
    AutoCompleteTextView userName;
    EditText password;

    private TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin=findViewById(R.id.loginButton);
        userName=findViewById(R.id.loginEmailField);
        password=findViewById(R.id.loginPasswordField);

        signup = findViewById(R.id.signup_text);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validate(userName.getText().toString(),password.getText().toString())) {
                    //some error message here
                } else {//TODO for userprofile
                    for(String item : StoreFragment.itemNamesArr) {
                        UserProfile.inventory.put(item, 1);
                    }
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), RegistrationActivity.class));
            }
        });
    }
    public boolean validate(String userName, String password) {
        if (userName.equals("Burdell") && password.equals("1234")) {
            return true;
        }
        else {
            return false;
        }
    }



    //sign up



}
