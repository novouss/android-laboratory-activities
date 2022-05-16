package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.firstapplication.DataBetweenActivity.Activity1;
import com.example.firstapplication.LyricsActivity.LyricsActivity;
import com.example.firstapplication.lib.Account;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Account acc;
    int LAUNCH_SECOND_ACTIVITY = 1;

    TextView greetingsTxt;
    Button basicCalBtn, advCalBtn, chatBtn, bmiCalBtn, lyricAppBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OpenLoginActivity();

        greetingsTxt = (TextView) findViewById(R.id.UserText);

        basicCalBtn = (Button) findViewById(R.id.BasicCalBtn);
        advCalBtn = (Button) findViewById(R.id.AdvCalBtn);
        chatBtn = (Button) findViewById(R.id.ChatBotBtn);
        bmiCalBtn = (Button) findViewById(R.id.BMICalBtn);
        lyricAppBtn = (Button) findViewById(R.id.LyricsAppBtn);
    }

    private void OpenLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivityForResult(intent, 1);
    }

    @Override
    public void onClick(View view) {
        Class context = null;

        switch (view.getId()) {
            case R.id.BasicCalBtn: context = BasicCalculatorActivity.class; break;
            // case R.id.AdvCalBtn: context = AdvanceCalculatorActivity.class; break;
            case R.id.ChatBotBtn: context = ChatBotActivity.class; break;
            case R.id.BMICalBtn: context = BMICalculatorActivity.class; break;
            case R.id.SecondScreenBtn: context = SecondaryScreenActivity.class; break;
            case R.id.LyricsAppBtn: context = LyricsActivity.class; break;
            case R.id.DatBetBtn: context = Activity1.class; break;
            case R.id.accountBtn: context = AccountActivity.class; break;
            case R.id.numerologyBtn: context = NumerologyActivity.class; break;
            default: return;
        }

        Intent intent = new Intent(this, context);
        intent.putExtra("RESULT", (Parcelable) acc);
        startActivity(intent);
    }

    public void LogoutBtn_OnClick(View view) {
        OpenLoginActivity();
    }

    @SuppressLint({"SetTextI18n", "ResourceType"})
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LAUNCH_SECOND_ACTIVITY) {
            if (resultCode == Activity.RESULT_OK) {
                acc = data.getParcelableExtra("RESULT");
                String greet = getResources().getString(R.string.greetings);
                greetingsTxt.setText(greet + " " + acc.getFirstname());
            }
        }
    }
}