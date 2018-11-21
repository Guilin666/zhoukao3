package bwie.example.com.guilin20181119.activity;

import bwie.example.com.guilin20181119.mvp.presenter.BaseActivityPresenter;
import bwie.example.com.guilin20181119.presenter.WebActivityPresenter;

public class WebActivity extends BaseActivityPresenter <WebActivityPresenter>{


    @Override
    public Class getDegateClass() {
        return WebActivityPresenter.class;
    }



}
