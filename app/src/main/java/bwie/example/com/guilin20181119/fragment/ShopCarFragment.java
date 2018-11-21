package bwie.example.com.guilin20181119.fragment;

import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import bwie.example.com.guilin20181119.R;
import bwie.example.com.guilin20181119.mvp.presenter.BaseFragmentPresenter;
import bwie.example.com.guilin20181119.presenter.ShopCarFragmentPresenter;

public class ShopCarFragment extends BaseFragmentPresenter <ShopCarFragmentPresenter>{
    @BindView(R.id.recycle_home)
    RecyclerView recycle_home;
    @Override
    public Class getDegateClass() {
        return ShopCarFragmentPresenter.class;
    }

    @Override
    public void initView() {
        super.initView();
        degate.initView(recycle_home);
    }

    public void setData() {

    }


}
