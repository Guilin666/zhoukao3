package bwie.example.com.guilin20181119.mvp.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public interface Degate {
    void iniData();
    void create(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);
    View getRootView();
    void setContext(Context context);
}

