package com.example.junhee.onsaveinstance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView textView2;
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("Main2Activity", "===== onCreate");
        Log.e("Main2Activity", "===============");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getBundle();
        initView();
        setBundle(savedInstanceState);
    }

    @Override
    protected void onRestart() {
        Log.e("Main2Activity", "===== onRestart");
        Log.e("Main2Activity", "===============");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        Log.e("Main2Activity", "===== onStart");
        Log.e("Main2Activity", "===============");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.e("Main2Activity", "===== onResume");
        Log.e("Main2Activity", "===============");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.e("Main2Activity", "===== onPause");
        Log.e("Main2Activity", "===============");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.e("Main2Activity", "===== onDestroy");
        Log.e("Main2Activity", "===============");
        super.onDestroy();
    }

    private void getBundle(){
        Intent intent = getIntent();
        data = intent.getStringExtra("string");
    }

    private void setBundle(Bundle savedInstanceState) {
        if (savedInstanceState != null)
            textView2.setText(savedInstanceState.getString("string"));
    }

    private void initView() {
        textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(data);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.e("Main2Activity", "===== onSaveInstanceState");
        Log.e("Main2Activity", "=========================");
        super.onSaveInstanceState(outState);

        if (textView2.getText().toString() != null) {
            StringBuilder builder = new StringBuilder(textView2.getText().toString());
            builder.append("+");
            outState.putString("string", builder.toString());
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.e("Main2Activity", "===== onSaveInstanceState");
        Log.e("Main2Activity", "=========================");
        super.onRestoreInstanceState(savedInstanceState);

        setBundle(savedInstanceState);
    }
}
