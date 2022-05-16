package com.example.firstapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class BMICalculatorActivity extends AppCompatActivity {

    DecimalFormat df = new DecimalFormat("0.00");
    EditText heightTextbox, weightTextbox;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculator);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        heightTextbox = (EditText) findViewById(R.id.HeightTextbox);
        weightTextbox = (EditText) findViewById(R.id.WeightTextbox);

        resultText = (TextView) findViewById(R.id.ResultText);

    }

    @SuppressLint("SetTextI18n")
    public void CalculateBtn_OnClick(View view) {
        double weight = Double.parseDouble(weightTextbox.getText().toString());
        double height = Double.parseDouble(heightTextbox.getText().toString());

        // Convert cm to m
        height = CentimetersToMeters(height);

        double bmi = getBMI(weight, height);
        String range = getBMIRange(bmi);

        resultText.setText("BMI\n" + df.format(bmi) + "\n" + range);
    }

    private String getBMIRange(double bmi) {

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25 && bmi >= 18.5) {
            return "Healthy Weight";
        } else if (bmi < 30 && bmi >= 25) {
            return "Overweight";
        } else {
            return "Obese";
        }

    }

    private double getBMI(double weight, double height) {
        return weight / (height * height);
    }

    private double CentimetersToMeters(double height) {
        return height / 100;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }
}