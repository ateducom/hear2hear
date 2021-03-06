package com.example.afraaaldhaheri.ateducom;

import android.app.ProgressDialog;
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


public class register extends AppCompatActivity implements View.OnClickListener {



//defining view objects
private EditText editTextEmail;
private EditText editTextPassword;
private ProgressDialog progressDialog;



//defining firebaseauth object
  private FirebaseAuth firebaseAuth;
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

//initializing firebase auth object
firebaseAuth = FirebaseAuth.getInstance();
//initializing views
editTextEmail = (EditText) findViewById(R.id.email);
editTextPassword = (EditText) findViewById(R.id.reg_password);
    Button buttonSignup = (Button) findViewById( R.id.btnRegister );
    Button tologin = (Button) findViewById( R.id.link_to_login );

progressDialog = new ProgressDialog(this);
//attaching listener to button
buttonSignup.setOnClickListener(this);

    tologin.setOnClickListener( new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(register.this, MainActivity.class);
            startActivity(intent);

        }
    });


}

private void registerUser(){
//getting email and password from edit texts
String email = editTextEmail.getText().toString().trim();
String password = editTextPassword.getText().toString().trim();

//checking if email and passwords are empty
if(TextUtils.isEmpty(email)){
Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
return;
}

if(TextUtils.isEmpty(password)){
Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
}

//if the email and password are not empty
//displaying a progress dialog

progressDialog.setMessage("Registering Please Wait...");
progressDialog.show();

//creating a new user
firebaseAuth.createUserWithEmailAndPassword(email, password)
.addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
@Override
public void onComplete(@NonNull Task<AuthResult> task) {
//checking if success
if(task.isSuccessful()){
//display some message here
Toast.makeText(register.this,"Successfully registered",Toast.LENGTH_LONG).show();
}else{
//display some message here
Toast.makeText(register.this,"Registration Error",Toast.LENGTH_LONG).show();
}
progressDialog.dismiss();
}
});
}
@Override
public void onClick(View view) {
//calling register method on click
registerUser();
}

}
