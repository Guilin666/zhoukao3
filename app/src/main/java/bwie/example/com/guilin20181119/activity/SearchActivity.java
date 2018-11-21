package bwie.example.com.guilin20181119.activity;

import bwie.example.com.guilin20181119.mvp.presenter.BaseActivityPresenter;
import bwie.example.com.guilin20181119.presenter.SearchActivityPresenter;

public class SearchActivity extends BaseActivityPresenter <SearchActivityPresenter>{


    @Override
    public Class getDegateClass() {
        return SearchActivityPresenter.class;
    }
}
