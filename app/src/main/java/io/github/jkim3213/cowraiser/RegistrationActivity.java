package io.github.jkim3213.cowraiser;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//import com.google.firebase.quickstart.auth.R;

import static java.sql.DriverManager.println;



public class RegistrationActivity extends AppCompatActivity {


    private static final String TAG = "MyActivity";


    private EditText email;
    private EditText pass;
    private Button btnReg;
    private TextView loginText;


   private FirebaseAuth mAuth;
   private ProgressDialog mDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //firebase
        mAuth = FirebaseAuth.getInstance();
        mDialog = new ProgressDialog(this);


        email = findViewById(R.id.email_login);
        pass = findViewById(R.id.password_reg);
        btnReg = findViewById(R.id.Reg_btn);
        loginText = findViewById(R.id.login_txt);


        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mEmail = email.getText().toString().trim();
                String mPass = pass.getText().toString().trim();

                if (TextUtils.isEmpty(mEmail)) {
                    email.setError("Required Field");
                    return;
                }
                if (TextUtils.isEmpty(mPass)) {
                    email.setError("Required Field");
                    return;
                }

                //working till this line
                //startActivity(new Intent(getApplicationContext(), MainActivity.class));

                //println("you are here");


                mDialog.setMessage("processing.....");
                mDialog.show();


                mAuth.createUserWithEmailAndPassword(mEmail, mPass)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        if (task.isSuccessful()) {

                            startActivity(new Intent(getApplicationContext(), MainActivity.class));

                            Toast.makeText(getApplicationContext(), "Finally Your registered to Database!!!", Toast.LENGTH_LONG);
                            mDialog.dismiss();
                        } else {

                            Toast.makeText(getApplicationContext(), "some problem, help is on the way", Toast.LENGTH_LONG);
                            mDialog.dismiss();

                        }

                    }
                });

                Log.e(TAG, "I should be here");

            }
        });
    }


}