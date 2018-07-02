package com.deom.android.bmi;


import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import java.security.DigestException;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    static {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
    }

    EditText et1, et2, fieldheight, fieldweight;
    TextView result, suggest;
    Button calcBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bim2);
        findViews();
        setOnClickListener();
    }

    private void findViews() {
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        calcBtn = findViewById(R.id.submit);
        fieldheight = findViewById(R.id.et1);
        fieldweight = findViewById(R.id.et2);
        result = findViewById(R.id.result);
        suggest = findViewById(R.id.suggest);
    }

    private void setOnClickListener() {
        calcBtn.setOnClickListener(calcBMI);
    }

    private View.OnClickListener calcBMI = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            try {
                DecimalFormat nf = new DecimalFormat("0.00");
                openOptionDialog();

                String h = fieldheight.getText().toString();
                String w = fieldweight.getText().toString();
                double height = Double.parseDouble(h) / 100;
                double weight = Double.parseDouble(w);
                double BMI = weight / (height * height);

                result.setText("Your BMI is" + nf.format(BMI));


                if (BMI > 25) {
                    suggest.setText(R.string.advice_heavy);
                } else if (BMI > 20) {
                    suggest.setText(R.string.advice_light);
                } else {
                    suggest.setText(R.string.advice_average);
                }
            } catch (NumberFormatException e) {
                result.setText("您是否未輸入身高及體重資料？請重新輸入");
            }
        }
    };
    private void openOptionDialog(){
        final ProgressDialog progressDialog
                =ProgressDialog
                .show(this,"處理中…","請等一會，處理完畢會自動結束…");
        Thread thread=new Thread(){
            @Override
            public void run(){
                try{
                    Thread.sleep(5000);

                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                progressDialog.dismiss();
            }
        };
        thread.start();
//        AlertDialog.Builder dialog= new AlertDialog.Builder(this);
//        dialog.setTitle("關於Android BMI");
//        dialog.setMessage("Android BMI Calc");
//        dialog.setPositiveButton("取消",listener1);
//        dialog.setNegativeButton("首頁",listener2);
//        dialog.setNeutralButton("確認",listener3);
//        dialog.show();

    }
    DialogInterface.OnClickListener listener1 =new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(MainActivity.this, "按下取消", Toast.LENGTH_SHORT).show();
        }
    };
    DialogInterface.OnClickListener listener2=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(MainActivity.this, "按下首頁", Toast.LENGTH_SHORT).show();
        }
    };
    DialogInterface.OnClickListener listener3 =new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(MainActivity.this, "按下確認", Toast.LENGTH_SHORT).show();
        }
    };
//    @Override
//    public void onClick(View v){
//        System.out.println("第一個欄位值："+ et1.getText());
//        System.out.println("第二個欄位值："+ et2.getText());
//        Toast.makeText(this, "顯示Toast訊息",Toast.LENGTH_LONG).show();
//    }
//    @Override
//    public void onClick(View v){
//        System.out.println("caleBMI");
//        System.out.println("第一個欄位值："+ et1.getText());
//        System.out.println("第二個欄位值："+ et2.getText());
//         Toast.makeText(this, "顯示Toast訊息",Toast.LENGTH_LONG).show();
//    }
//
//    public void onClean(View v){
//       et1.setText("");
//       et2.setText("");
    //        Toast.makeText(this, "清除欄位",Toast.LENGTH_LONG).show();
//    }

}
