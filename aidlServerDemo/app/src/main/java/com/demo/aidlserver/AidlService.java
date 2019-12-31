package com.demo.aidlserver;


import com.demo.aidl.IaidlTest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class AidlService extends Service {

    private mAidlService mBinder = null;

    public class mAidlService extends IaidlTest.Stub
    {
        @Override
        public String  aidlTest()
        {
            return "hello world!";
        }
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        Log.d("cmdcAidlServer", "service onCreate!");
        mBinder = new mAidlService();
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        Log.d("cmdcAidlServer", "service onBind!");
        return mBinder;
    }

    @Override
    public void onDestroy() {
        Log.d("cmdcAidlServer", "service onDestroy!");
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent)
    {
        super.onUnbind(intent);
        Log.d("cmdcAidlServer", "service onUnbind!");
        return true;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Log.d("cmdcAidlServer", "service onStartCommand!");
        return super.onStartCommand(intent, flags, startId);
    }
}

