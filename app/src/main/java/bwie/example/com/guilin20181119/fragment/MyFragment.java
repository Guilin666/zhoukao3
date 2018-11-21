package bwie.example.com.guilin20181119.fragment;

import bwie.example.com.guilin20181119.mvp.presenter.BaseFragmentPresenter;
import bwie.example.com.guilin20181119.presenter.MyFragmentPresenter;

public class MyFragment extends BaseFragmentPresenter<MyFragmentPresenter>{
    @Override
    public Class getDegateClass() {
        return MyFragmentPresenter.class;
    }


    public void refresh() {
        degate.refresh();
    }
}
