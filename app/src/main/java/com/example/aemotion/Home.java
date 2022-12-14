package com.example.aemotion;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;


public class Home extends AppCompatActivity {
    private View decorView;
    private int	uiOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //bgm 실행하기
        Intent intent = new Intent(getApplicationContext(), MusicService.class);
        startService(intent);

        decorView = getWindow().getDecorView();
        uiOption = getWindow().getDecorView().getSystemUiVisibility();
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH )
            uiOption |= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN )
            uiOption |= View.SYSTEM_UI_FLAG_FULLSCREEN;
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT )
            uiOption |= View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        decorView.setSystemUiVisibility( uiOption );

        Button crbtn = (Button)findViewById(R.id.crbtn);
        crbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Copyright.class);
                startActivity(intent);
            }
        });

        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.bounce);

        Button level1 = (Button) findViewById(R.id.level1);
        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                level1.startAnimation(animation);

                Intent intent = new Intent(getApplicationContext(), Level1.class);
                startActivity(intent);

            }
        });

        Button level2 = (Button) findViewById(R.id.level2);
        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                level2.startAnimation(animation);

                Intent intent = new Intent(getApplicationContext(), Level2.class);
                startActivity(intent);

            }
        });

        Button level3 = (Button) findViewById(R.id.level3);
        level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                level3.startAnimation(animation);


                Intent intent = new Intent(getApplicationContext(), Level3.class);
                startActivity(intent);

            }
        });
    }
}