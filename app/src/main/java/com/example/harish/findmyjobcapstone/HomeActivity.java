package com.example.harish.findmyjobcapstone;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {


    private static int SPLASH_SCREEEN=3000;

    Animation topanim,bottomanim;
    ImageView image;
    TextView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home2);
        topanim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomanim=AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        image=findViewById(R.id.imageViews);
        logo=findViewById(R.id.textView2);

        image.setAnimation(topanim);
        logo.setAnimation(bottomanim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(HomeActivity.this,MainActivity.class);
                Intent intent = new Intent(HomeActivity.this, Main3Activity.class);
                Pair[] pairs=new Pair[2];
                pairs[0]=new Pair<View,String>(image,"imgtra");
                pairs[1]=new Pair<View,String>(logo,"texttra");

                ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this,pairs);

                startActivity(i,options.toBundle());
                finish();
            }
        },SPLASH_SCREEEN);
    }
}

