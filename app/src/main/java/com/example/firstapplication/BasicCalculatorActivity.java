package com.example.firstapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BasicCalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    Button AddBtn, SubtractBtn, MultiplyBtn, DivideBtn;
    EditText Numbox1, Numbox2, Resultbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_calculator);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        AddBtn = (Button) findViewById(R.id.AddBtn);
        SubtractBtn = (Button) findViewById(R.id.SubtractBtn);
        MultiplyBtn = (Button) findViewById(R.id.MultiplyBtn);
        DivideBtn = (Button) findViewById(R.id.DivideBtn);

        Numbox1 = (EditText) findViewById(R.id.NumberTextbox1);
        Numbox2 = (EditText) findViewById(R.id.NumberTextbox2);
        Resultbox = (EditText) findViewById(R.id.ResultTextbox);
    }

    @Override
    public void onClick(View view) {
        double num1 = getDouble(Numbox1);
        double num2 = getDouble(Numbox2);
        double sum = 0;

        switch (view.getId()) {
            case R.id.AddBtn:
                sum = num1 + num2;
                break;
            case R.id.SubtractBtn:
                sum = num1 - num2;
                break;
            case R.id.MultiplyBtn:
                sum = num1 * num2;
                break;
            case R.id.DivideBtn:
                sum = num1 / num2;
                break;
        }

        Resultbox.setText(sum + "");
    }

    public void ClearBtn_OnClick(View view) {
        Numbox1.setText("");
        Numbox2.setText("");
        Resultbox.setText("");
    }

    public double getDouble(EditText edit) { return Double.parseDouble(edit.getText().toString()); }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }
}