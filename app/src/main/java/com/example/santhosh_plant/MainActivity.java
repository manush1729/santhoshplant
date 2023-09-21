package com.example.santhosh_plant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    TextView quote;
    ImageView enter;
    VideoView background;
    String[] quotes = {"If you tickle the Earth with a hoe she laughs with a laughs \n\n  - Douglas Jerrold","Country without a farmer is a tree without a fruit","Agriculture is not a farming, It's feeding","We're facing tough times in agriculture. But farmers are nothing if not resilient.\n\n - John Motter","I love every minute I get to spend in a tractor. \n\n - Austin Wiseman","Agriculture is a universal language. \n\n  - Brielle Wright","Farming is a family affair. \n\n  - Kyla Mauk"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        quote = findViewById(R.id.quotes);
        backgroundVideo();
               quote.setText(quotes[(int) Math.floor(Math.random() * quotes.length)]);
               enter = findViewById(R.id.login);
               enter.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent i = new Intent(MainActivity.this,HomeActivity.class);
                       startActivity(i);
                   }
               });
    }

    public void backgroundVideo()
    {
        background = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.background);
        background.setVideoURI(uri);
        background.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });
        background.start();
    }
}