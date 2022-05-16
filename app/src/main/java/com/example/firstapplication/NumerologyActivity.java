package com.example.firstapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class NumerologyActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nameTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numerology);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        nameTxt = (EditText) findViewById(R.id.NameTxt);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, NumerologyOutput.class);
        intent.putExtra("NAME", nameTxt.getText().toString());
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }

}