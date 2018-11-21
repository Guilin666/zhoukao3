package bwie.example.com.guilin20181119.mvp.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import bwie.example.com.guilin20181119.mvp.view.DegateImpl;
//抽取fragment

public abstract class BaseFragmentPresenter <T extends DegateImpl>extends Fragment {
    public   T degate;
    private Unbinder bind;

    public  abstract Class<T> getDegateClass();
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            degate = getDegateClass().newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        degate.create(inflater,container,savedInstanceState);
        return degate.getRootView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        degate.setContext(getActivity());
        bind = ButterKnife.bind(this, degate.getRootView());
        initView();
        degate.iniData();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
        degate.destoryView();
        degate=null;
    }

    public  void initView(){

    }

}

