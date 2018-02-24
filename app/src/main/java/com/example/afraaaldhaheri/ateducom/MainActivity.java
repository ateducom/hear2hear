package com.example.afraaaldhaheri.ateducom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText coursename,instructurename;
    private Button reviewnote, addnote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        addnote = (Button) findViewById( R.id.addnote );
        reviewnote=(Button) findViewById( R.id.review );
        instructurename = (EditText) findViewById( R.id.instructure );
        coursename = (EditText) findViewById( R.id.coursename );


        reviewnote.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, notepage.class);
                intent.putExtra("instructure name:", instructurename.getText().toString());
                intent.putExtra( "course name:", coursename.getText().toString() );
                startActivity(intent);
            }
        } );

        addnote.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, recordpage.class);
                startActivity(intent);
            }
        } );

/*
 btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(prevactivity.this, homepage.class);
                intent.putExtra("greenhouse_name",txt.getText().toString());
               startActivity(intent);
 */


/*
tb.setText(getIntent().getExtras().getString("greenhouse_name"));
 */
    }





}
