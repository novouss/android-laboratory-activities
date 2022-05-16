package com.example.firstapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.firstapplication.lib.Account;

public class AccountActivity extends AppCompatActivity {

    Account acc;
    TextView nameTxt, emailTxt, programTxt, courseTxt1, courseTxt2, courseTxt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        acc = getIntent().getParcelableExtra("RESULT");

        nameTxt = findViewById(R.id.nameTxt);
        emailTxt = findViewById(R.id.emailTxt);
        programTxt = findViewById(R.id.programTxt);
        courseTxt1 = findViewById(R.id.courseTxt1);
        courseTxt2 = findViewById(R.id.courseTxt2);
        courseTxt3 = findViewById(R.id.courseTxt3);

        nameTxt.setText("Hello " + acc.getFirstname() + " " + acc.getLastname());
        emailTxt.setText("Your email is " + acc.getEmail());
        programTxt.setText("You\'re enrolled in " + acc.getProgram());
        courseTxt1.setText(acc.getCourse1());
        courseTxt2.setText(acc.getCourse2());
        courseTxt3.setText(acc.getCourse3());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }

}