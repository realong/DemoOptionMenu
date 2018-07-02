package com.leilong.bulbcartoon;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class bulb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulb);
        ImageView img  = findViewById(R.id.bright);
        Animation am= AnimationUtils.loadAnimation(this,R.anim.anim);
        img.setAnimation(am);
        am.start();
    }
}
