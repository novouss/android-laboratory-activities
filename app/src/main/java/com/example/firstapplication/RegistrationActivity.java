package com.example.firstapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.firstapplication.lib.Account;

public class RegistrationActivity extends AppCompatActivity {

    EditText usernameTextbox, emailTextbox, firstnameTextbox, lastnameTextbox, passwordTextbox;
    EditText programTextbox, courseTextbox1, courseTextbox2, courseTextbox3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        usernameTextbox = findViewById(R.id.usernameTextbox);
        emailTextbox = findViewById(R.id.EmailTextbox);
        firstnameTextbox = findViewById(R.id.FirstnameTextbox);
        lastnameTextbox = findViewById(R.id.LastnameTextbox);
        passwordTextbox = findViewById(R.id.PasswordTextbox);

        programTextbox = findViewById(R.id.ProgramTextbox);
        courseTextbox1 = findViewById(R.id.CourseTextbox1);
        courseTextbox2 = findViewById(R.id.CourseTextbox2);
        courseTextbox3 = findViewById(R.id.CourseTextbox3);
    }

    public void CreateBtn_OnClick(View view) {

        if (checkData()) {
            Account account = new Account();
            account.setUsername(usernameTextbox.getText().toString());
            account.setEmail(emailTextbox.getText().toString());
            account.setFirstname(firstnameTextbox.getText().toString());
            account.setLastname(lastnameTextbox.getText().toString());
            account.setProgram(programTextbox.getText().toString());
            account.setCourse1(courseTextbox1.getText().toString());
            account.setCourse2(courseTextbox2.getText().toString());
            account.setCourse3(courseTextbox3.getText().toString());
            account.setPassword(passwordTextbox.getText().toString());

            Intent result = new Intent();
            result.putExtra("RESULT", (Parcelable) account);
            setResult(Activity.RESULT_OK, result);
            finish();

        }

    }

    boolean checkData() {

        boolean isValid = true;

        if (isEmpty(usernameTextbox)) {
            firstnameTextbox.setError("Enter Username!");
            isValid = false;
        }

        if (!isEmail(emailTextbox)) {
            emailTextbox.setError("Enter valid email!");
            isValid = false;
        }

        if (isEmpty(firstnameTextbox)) {
            firstnameTextbox.setError("Enter Firstname!");
            isValid = false;
        }

        if (isEmpty(lastnameTextbox)) {
            lastnameTextbox.setError("Enter Lastname!");
            isValid = false;
        }

        if (isEmpty(passwordTextbox)) {
            lastnameTextbox.setError("Enter Password!");
            isValid = false;
        }

        return isValid;
    }

    boolean isEmpty(EditText textbox) {
        CharSequence str = textbox.getText().toString();
        return TextUtils.isEmpty(str);
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }
}