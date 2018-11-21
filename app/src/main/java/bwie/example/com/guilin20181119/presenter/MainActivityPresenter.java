package bwie.example.com.guilin20181119.presenter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bwie.example.com.guilin20181119.R;
import bwie.example.com.guilin20181119.activity.MainActivity;
import bwie.example.com.guilin20181119.fragment.MyFragment;
import bwie.example.com.guilin20181119.fragment.ShopCarFragment;
import bwie.example.com.guilin20181119.model.DataBean;
import bwie.example.com.guilin20181119.mvp.view.DegateImpl;
import bwie.example.com.guilin20181119.utils.GreenSqlUtils;

public class MainActivityPresenter extends DegateImpl {
    private ViewPager viewpager_main;
    private List<Fragment> mFragments=new ArrayList<>();
    private String []mTitles={"购物车","我的"};
    private TabLayout table_main;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void iniData() {
        super.iniData();
        mFragments.add(new ShopCarFragment());
        mFragments.add(new MyFragment());
        FragmentManager supportFragmentManager = ((MainActivity) context).getSupportFragmentManager();

        viewpager_main.setAdapter(new FragmentPagerAdapter(supportFragmentManager) {

            @Override
            public Fragment getItem(int i) {
                return mFragments.get(i);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles[position];
            }
        });

        table_main.setupWithViewPager(viewpager_main);
        table_main.setTabMode(TabLayout.MODE_FIXED);

//        if (mFragments != null) {
//            for(int i=0;i<mFragments.size();i++){
//                Fragment fragment = mFragments.get(i);
//
//
//            }
//        }



        viewpager_main.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                Fragment fragment = mFragments.get(i);
                if (  fragment instanceof MyFragment) {
                    ((MyFragment) mFragments.get(i)).refresh();

                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });



    }

    private Context context;
    @Override
    public void setContext(Context context) {
        super.setContext(context);
        this.context=context;
    }

    public void initView(ViewPager viewpager_main, TabLayout table_main) {
        this.viewpager_main=viewpager_main;
        this.table_main=table_main;
    }
}
