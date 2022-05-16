package com.example.firstapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ChatBotActivity extends AppCompatActivity implements View.OnClickListener {

    TextView chatbox;
    EditText messagebox;
    Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        chatbox = findViewById(R.id.chatbox);
        messagebox = findViewById(R.id.messagebox);
        sendBtn = findViewById(R.id.sendBtn);

        sendBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.sendBtn) {
            String text = chatbox.getText().toString() + "\n" + messagebox.getText().toString();
            chatbox.setText(text);
            messagebox.setText("");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }
}