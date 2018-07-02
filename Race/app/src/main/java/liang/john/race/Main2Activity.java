package liang.john.race;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main2Activity extends AppCompatActivity {


    WebView my_reseme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //////連結my_reseme到頁面上的WebView
        my_reseme = this.findViewById(R.id.my_resume);

        WebSettings webSettings = my_reseme.getSettings();
        webSettings.setJavaScriptEnabled(true);

        my_reseme.setWebViewClient(new WebViewClient());
        my_reseme.loadUrl("https://puxin2-d4b1c.firebaseapp.com/");

    }
}
