package bwie.example.com.guilin20181119.mvp.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import bwie.example.com.guilin20181119.mvp.view.DegateImpl;
//抽取基类

public abstract class BaseActivityPresenter<T extends DegateImpl> extends AppCompatActivity {

    public T degate;

    public abstract Class<T> getDegateClass();

    public BaseActivityPresenter() {

        try {
            degate = getDegateClass().newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        degate.setContext(this);
        degate.create(getLayoutInflater(), null, savedInstanceState);
        setContentView(degate.getRootView());
        ButterKnife.bind(this);
        initView();
        degate.iniData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        degate.destoryView();
        degate = null;
    }

    public void initView() {

    }

}
