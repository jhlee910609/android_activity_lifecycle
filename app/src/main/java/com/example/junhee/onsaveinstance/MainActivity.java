package com.example.junhee.onsaveinstance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * activity 생명주기 확인을 위해 호출되는 곳마다 Log.e를 찍어 확인하였다.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private TextView textView;
    private Button button;
    private String data;
    private Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("MainActivity", "===== onCreate");
        Log.e("MainActivity", "===============");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    protected void onStart() {
        Log.e("MainActivity", "===== onStart");
        Log.e("MainActivity", "===============");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.e("MainActivity", "===== onRestart");
        Log.e("MainActivity", "===============");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.e("MainActivity", "===== onResume");
        Log.e("MainActivity", "===============");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.e("MainActivity", "===== onPause");
        Log.e("MainActivity", "===============");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e("MainActivity", "===== onStop");
        Log.e("MainActivity", "===============");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.e("MainActivity", "===== onDestroy");
        Log.e("MainActivity", "===============");
        super.onDestroy();
    }


    private void initView() {
        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        btnGo = (Button) findViewById(R.id.btnGo);

        button.setOnClickListener(this);
        btnGo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                data = editText.getText().toString();
                textView.setText(data);
                break;

            case R.id.btnGo:
                Intent intent = new Intent(this, Main2Activity.class);
                intent.putExtra("string", this.data);
                startActivity(intent);
                break;
        }
    }

    // 기존 액티비티의 onPause 후, 호출된다.
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.e("MainActivity", "===== onSaveInstanceState");
        Log.e("MainActivity", "=========================");
        super.onSaveInstanceState(outState);

        if (data != null) {
            StringBuilder builder = new StringBuilder(data);
            builder.append("!");
            data = builder.toString();
            outState.putString("string", data);
        }
    }

    // 액티비티가 회전된 후, onStart 뒤에 호출된다.
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.e("MainActivity", "===== onRestoreInstanceState");
        Log.e("MainActivity", "=========================");
        super.onRestoreInstanceState(savedInstanceState);
        if (data != null || !"".equals(data)) {
            data = savedInstanceState.getString("string");
            textView.setText(data);
        }
    }
}
