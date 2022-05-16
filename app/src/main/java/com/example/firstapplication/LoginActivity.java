package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.firstapplication.lib.Account;
import com.example.firstapplication.lib.Database;

public class LoginActivity extends AppCompatActivity {

    Database db = new Database();
    Button login;
    EditText username, password;
    int LAUNCH_SECOND_ACTIVITY = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button) findViewById(R.id.LoginBtn);

        username = (EditText) findViewById(R.id.UsernameTextbox);
        password = (EditText) findViewById(R.id.PasswordTextbox);
    }

    public void LoginBtn_OnClick(View view) {
        String user = username.getText().toString();
        String pass = password.getText().toString();

        if (db.checkAccount(user, pass)) {
            Account acc = db.getAccount(user);

            Intent result = new Intent();
            result.putExtra("RESULT", (Parcelable) acc);
            setResult(Activity.RESULT_OK, result);
            finish();
            return;
        }

        // Failed to Authenticate
        username.setText("");
        password.setText("");
        login.setText("Failed to Login!");
        login.setBackgroundResource(R.color.crimson);
    }

    public void CreateBtn_OnClick(View view) {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivityForResult(intent, 2);
    }

    public void RestartLogin_OnClick(View view) {
        login.setText(R.string.login);
        login.setBackgroundResource(R.color.slate_blue);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LAUNCH_SECOND_ACTIVITY) {
            if (resultCode == Activity.RESULT_OK){
                Account acc = data.getParcelableExtra("RESULT");
                db.addAccount(acc);
            }
        }
    }
}