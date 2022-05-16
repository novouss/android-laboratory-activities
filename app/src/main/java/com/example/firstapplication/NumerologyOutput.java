package com.example.firstapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NumerologyOutput extends AppCompatActivity implements  View.OnClickListener{

    String name;
    TextView output, score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numerology_output);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        score = (TextView) findViewById(R.id.ScoreTxt);
        output = (TextView) findViewById(R.id.OutputText);

        name = getIntent().getExtras().getString("NAME");
        start();
    }

    public void start() {
        int sum = 0;
        int points = 0;

        for(char c: name.toCharArray()) {

            if (Character.isLetter(c)) {
                sum += numerology(c);
            }
        }
        points = sum;
        sum = name_number(sum);
        score.setText(points + " (" + sum + ")");
        output.setText(descriptor(sum));
    }

    public int numerology (char x) {
        int ascii = (int) Character.toUpperCase(x);
        return ((ascii - 'A') % 9) + 1;
    }

    public int name_number (int x) {

        if (x == 11 || x == 22 || x == 33 || x < 10) {
            return x; // If sum is any of the master numbers, or so long as x is less than 10, return. Else, continue
        }

        String y = x + ""; // Convert int to String by concatenating
        int sum = 0; // Initialize sum variable

        for (int i = 0; i < y.length(); i++) {
            sum += Integer.parseInt(y.charAt(i) + ""); // Loop through the string adding each number to the sum variable
        }

        return name_number(sum);

    }

    public String descriptor(int x) {

        switch (x) {
            case 1:
                return getResources().getString(R.string.numerology1);
            case 2:
                return getResources().getString(R.string.numerology2);
            case 3:
                return getResources().getString(R.string.numerology3);
            case 4:
                return getResources().getString(R.string.numerology4);
            case 5:
                return getResources().getString(R.string.numerology5);
            case 6:
                return getResources().getString(R.string.numerology6);
            case 7:
                return getResources().getString(R.string.numerology7);
            case 8:
                return getResources().getString(R.string.numerology8);
            case 9:
                return getResources().getString(R.string.numerology9);
            case 11:
                return getResources().getString(R.string.numerology11);
            case 22:
            case 33:
                return getResources().getString(R.string.numerology22);
        }

        return null;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, NumerologyOthers.class);
        startActivity(intent);
    }
}