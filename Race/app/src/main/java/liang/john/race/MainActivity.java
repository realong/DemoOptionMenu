package liang.john.race;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        //隱藏標題列
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //隱藏狀態列
        this.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        */
        setContentView(R.layout.activity_main_john);

        MediaPlayer player;
        player = MediaPlayer.create(this,R.raw.beginning_trumpet);
        player.start();

    }
    public void go_home(View v){

        System.out.println("你按下HOME了");
        Intent go;
        go = new Intent(this,Main2Activity.class);

        this.startActivity(go);

    }
}
