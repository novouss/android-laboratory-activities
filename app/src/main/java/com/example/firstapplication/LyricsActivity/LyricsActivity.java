package com.example.firstapplication.LyricsActivity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.firstapplication.R;

public class LyricsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyrics);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }

    @Override
    public void onClick(View view) {
        Class context = null;

        switch(view.getId()) {
            case R.id.track1: context = LyricsViewerTrack1.class; break;
            case R.id.track2: context = LyricsViewerTrack2.class; break;
            case R.id.track3: context = LyricsViewerTrack3.class; break;
            case R.id.track4: context = LyricsViewerTrack4.class; break;
            case R.id.ConfirmButton: context = LyricsViewerTrack5.class; break;
        }

        Intent intent = new Intent(this, context);
        startActivity(intent);
    }
}