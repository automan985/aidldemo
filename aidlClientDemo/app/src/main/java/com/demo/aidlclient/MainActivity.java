package com.demo.aidlclient;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.demo.aidl.IaidlTest;

public class MainActivity extends Activity {

    IaidlTest iaidlTest;

    private ServiceConnection conn = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service)
        {
            iaidlTest = IaidlTest.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name)
        {
            Log.d("aidlclient", "onServiceDisconnected");
            iaidlTest = null;
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView text = findViewById(R.id.text);
        Button test = findViewById(R.id.test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(null != iaidlTest) {
                        String value = iaidlTest.aidlTest();
                        text.setText(value);
                    }
                    else {
                        text.setText("aidlTest is null");
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        Intent intent = new Intent();
        intent.setAction("com.demo.aidlserver");
        intent.setPackage("com.demo.aidlserver");
        bindService(intent,conn, Service.BIND_AUTO_CREATE);
    }

    @Override
    public  void onDestroy() {
        super.onDestroy();
        Log.d("aidlclient", "destroy and unbindService" );
        unbindService(conn);
    }
}