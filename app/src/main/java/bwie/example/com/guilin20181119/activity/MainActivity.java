package bwie.example.com.guilin20181119.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import butterknife.BindView;
import bwie.example.com.guilin20181119.R;
import bwie.example.com.guilin20181119.mvp.presenter.BaseActivityPresenter;
import bwie.example.com.guilin20181119.presenter.MainActivityPresenter;

public class MainActivity extends BaseActivityPresenter <MainActivityPresenter>{

    @BindView(R.id.viewpager_main)
//
    ViewPager viewpager_main;
    @BindView(R.id.table_main)
    TabLayout table_main;
    @Override
    public Class getDegateClass() {
        return MainActivityPresenter.class;
    }

    @Override
    public void initView() {
        super.initView();
        degate.initView(viewpager_main,table_main);
    }


}
