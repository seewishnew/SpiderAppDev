package com.example.vishnu.taskone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String name = getIntent().getStringExtra(MainActivity.NAME);

        TextView textView = (TextView) findViewById(R.id.thankYou);
        textView.setText("Thank You " + name+ "\nfor your response");

        TextView textView1 = (TextView) findViewById(R.id.textView2);

        Long tsLong = System.currentTimeMillis()/1000;
        String ts = tsLong.toString();

        textView1.setText(ts);

    }

    public void back(View view) {

        setResult(RESULT_OK);
        finish();
    }
}
