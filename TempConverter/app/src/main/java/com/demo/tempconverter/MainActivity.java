package com.demo.tempconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnKeyListener {

    EditText etC, etF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setListeners();
    }

    private void findViews() {
        etC = findViewById(R.id.etC);
        etF = findViewById(R.id.etF);
    }

    private void setListeners() {
//        etC.setOnKeyListener(this);
//        etF.setOnKeyListener(this);
        etC.addTextChangedListener(tw1);
        etF.addTextChangedListener(tw2);
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (KeyEvent.ACTION_DOWN == event.getAction() && keyCode == KeyEvent.KEYCODE_ENTER) {
            System.out.println("v = " + v + " , keyCode = " + keyCode + " , event = " + event);
            try{
                if (v == etC) {
                    convertCToF(((EditText) v).getText());
                } else if (v == etF) {
                    convertFToC(((EditText) v).getText());
                }
            }catch (Exception e){

            }

        }

        return false;
    }

    private void convertCToF(CharSequence s) {
        double c = Double.parseDouble(s.toString());
        double f = c * 9 / 5 + 32;
        etF.setText(f + "");
    }

    private void convertFToC(CharSequence s) {
        double f = Double.parseDouble(s.toString());
        double c = (f - 32) * 5 / 9;
        etC.setText(c + "");
    }

    TextWatcher tw1 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            etF.removeTextChangedListener(tw2);
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            convertCToF(s);
        }

        @Override
        public void afterTextChanged(Editable s) {
            etF.addTextChangedListener(tw2);
        }
    };

    TextWatcher tw2 = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            etC.removeTextChangedListener(tw1);
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            convertFToC(s);
        }

        @Override
        public void afterTextChanged(Editable s) {
            etC.addTextChangedListener(tw1);
        }
    };


}
