package com.example.firstapplication.DataBetweenActivity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.firstapplication.R;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }

    public void Send_OnClick(View view) {
        Intent intent = new Intent(this, Activity2.class);
        EditText text = findViewById(R.id.UserDefTextbox);
        intent.putExtra("key", text.getText().toString());
        startActivity(intent);
    }
}