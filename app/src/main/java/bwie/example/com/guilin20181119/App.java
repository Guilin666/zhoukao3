package bwie.example.com.guilin20181119;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import bwie.example.com.guilin20181119.utils.GreenSqlUtils;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
