package com.demo.aidlserver;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);
        textView.setText("aidlserverdemo");
        Log.d("aidlserver", "start service in MainActivity!");
    }

    @Override
    public void onStart()
    {
        super.onStart();
        Log.d("aidlserver", "start MainActivity!");
    }

    @Override
    public void onResume(){
        super.onResume();
       // finish();// 6.0以上版本 NoDisplay 主题必须在onResume中 finish();
    }

    @Override
    public void onPause()
    {
        super.onPause();
    }

    @Override
    public void onStop()
    {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

