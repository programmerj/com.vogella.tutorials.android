package com.vogella.android.butterknifeexample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {
    @BindView(R.id.textView)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        title.setText("Hello from Butterknife");
    }

    @OnClick(R.id.button)
    public void submit() {
        Toast.makeText(MainActivity.this,
        		"Hello from Butterknife OnClick annotation", Toast.LENGTH_SHORT).show();
    }

}