package bwie.example.com.guilin20181119.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import bwie.example.com.guilin20181119.R;
import bwie.example.com.guilin20181119.adapter.ShowAdapter;
import bwie.example.com.guilin20181119.model.DataBean;
import bwie.example.com.guilin20181119.mvp.view.DegateImpl;
import bwie.example.com.guilin20181119.utils.GreenSqlUtils;

public class MyFragmentPresenter extends DegateImpl {

    private RecyclerView reclcye_show;
    private ShowAdapter showAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.myfragment_layout;
    }

    @Override
    public void iniData() {
        super.iniData();
        reclcye_show = (RecyclerView)get(R.id.reclcye_show);
        showAdapter = new ShowAdapter(context);
        new GreenSqlUtils(context).deleteAll();
    }


    private Context context;
    @Override
    public void setContext(Context context) {
        super.setContext(context);
        this.context=context;
    }


    public void refresh() {

        List<DataBean> dataBeans = new GreenSqlUtils(context).selectAll();
        if (dataBeans != null) {

                showAdapter.setList(dataBeans);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                reclcye_show.setLayoutManager(linearLayoutManager);
                reclcye_show.setAdapter(showAdapter);

        }
    }
}
