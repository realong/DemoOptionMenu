package com.demo.android.onclicklinstenerex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
//import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button button1, button2, button3, button4;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找出 Button 與 ImageView 的UI元件，試寫出來
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        imageView = findViewById(R.id.imageView1);
        //委託匿名的監聽器，試寫出來
        button1.setOnClickListener(R.id.button1);
        button2.setOnClickListener(R.id.button2);
        button3.setOnClickListener(R.id.button3);
        button4.setOnClickListener(R.id.button4);
    }

    //負責顯示圖片的監聽器
    //private View.OnClickListener displayImg;
    //imageView.setVisibility(View.VISIBLE);
    View.OnClickListener displayImg = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            imageView.setVisibility(View.VISIBLE);
        }
    };


    //負責隱藏圖片的監聽器
    //private View.OnClickListener hideImg;
    //imageView.setVisibility(View.INVISIBLE);
    View.OnClickListener hideImg = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            imageView.setVisibility(View.INVISIBLE);
        }
    };


    int h, w;
    //負責放大圖片的監聽器
    //private View.OnClickListener roomIn;
//			h = imageView.getHeight();
//			w = imageView.getWidth();
//			imageView.setLayoutParams(new LinearLayout.LayoutParams(h+=10, w+=10));
    View.OnClickListener roomIn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            h = imageView.getHeight();
            w = imageView.getWidth();
            imageView.setLayoutParams(new LinearLayout.LayoutParams(h += 10, w += 10));
        }
    };

    //負責縮小圖片的監聽器
    //private View.OnClickListener roomOut;
//			h = imageView.getHeight();
//			w = imageView.getWidth();
//			if(h> 10 & w > 10)
//			imageView.setLayoutParams(new LinearLayout.LayoutParams(h-=10, w-=10));
    View.OnClickListener roomOut = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            h = imageView.getHeight();
            w = imageView.getWidth();
            if (h > 10 & w > 10)
                imageView.setLayoutParams(new LinearLayout.LayoutParams(h -= 10, w -= 10));
        }
    };
}