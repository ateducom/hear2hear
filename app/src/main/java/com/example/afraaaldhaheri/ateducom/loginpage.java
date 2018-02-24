package com.example.afraaaldhaheri.ateducom;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginpage extends AppCompatActivity {

    private EditText emailedittext;
    private EditText passedittext;
    private Button butn;
    private Button tologin;
    private FirebaseAuth mAuth;
    private boolean task;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_loginpage );


        mAuth = FirebaseAuth.getInstance();
        emailedittext= (EditText) findViewById(R.id.email);
        passedittext= (EditText) findViewById(R.id.reg_password);
        butn = (Button) findViewById(R.id.btnLogin);
        tologin = (Button) findViewById(R.id.btn_link_to_register);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {


                if(firebaseAuth.getCurrentUser() != null){

                }
            }
        };


        //go to signup page

        tologin.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSignIn();
                Intent intent = new Intent(loginpage.this, register.class);
                startActivity(intent);
            }
        } );

        //login btn
        butn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginpage.this, MainActivity.class);
                startActivity(intent);


            }
        });


    }

    private void startSignIn(){
        String email = emailedittext.getText().toString();
        String password = passedittext.getText().toString();

        if(TextUtils.isEmpty(email)|| TextUtils.isEmpty(password)) {

            Toast.makeText( loginpage.this, "Feild are empty..",
                    Toast.LENGTH_SHORT ).show();
        }
        else {
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                Toast.makeText( loginpage.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT ).show();
                            }

                        }

                    });

        }}
}
