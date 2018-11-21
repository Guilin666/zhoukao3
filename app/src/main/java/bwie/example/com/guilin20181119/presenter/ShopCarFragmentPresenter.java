package bwie.example.com.guilin20181119.presenter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import bwie.example.com.guilin20181119.R;
import bwie.example.com.guilin20181119.activity.SearchActivity;
import bwie.example.com.guilin20181119.adapter.SellerAdapter;
import bwie.example.com.guilin20181119.model.GoodBean;
import bwie.example.com.guilin20181119.mvp.view.DegateImpl;
import bwie.example.com.guilin20181119.utils.HttpUtil;

public class ShopCarFragmentPresenter extends DegateImpl implements View.OnClickListener {
    private RecyclerView recycle_home;
    private SellerAdapter sellerAdapter;
    private CheckBox quan;
    private List<GoodBean.DataBean> data1=new ArrayList<>();
    private TextView tv_now_price;
    private Button btn_now_num;

    @Override
    public int getLayoutId() {
        return R.layout.shopcarfragment_layout;
    }

    @Override
    public void iniData() {
        super.iniData();
        //全选
        get(R.id.tv_edt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,SearchActivity.class));
            }
        });
        quan = (CheckBox) get(R.id.quan);
        tv_now_price = (TextView)get(R.id.tv_now_price);
        btn_now_num = (Button)get(R.id.btn_now_num);

        setOnclick(this,R.id.quan);
        sellerAdapter = new SellerAdapter(context);
        //接口回调
        sellerAdapter.setSellerListener(new SellerAdapter.SellerListener() {
            @Override
            public void sellerChange(List<GoodBean.DataBean> list) {
                int num=0;
                double price=0;
                int numAll=0;
                for(int i=0;i<list.size();i++){
                    List<GoodBean.DataBean.ListBean> list1 = list.get(i).getList();

                    for(int j=0;j<list1.size();j++){
                        numAll+=list1.get(j).getNum();//总价
                        if (list1.get(j).isIscheck()) {
                            num+= list1.get(j).getNum();
                            price+=list1.get(j).getPrice()*list1.get(j).getNum();
                        }


                    }
                }

                if (num <numAll) {
                    quan.setChecked(false);
                }else {
                    quan.setChecked(true);
                }

                tv_now_price.setText("总价:"+price);
                btn_now_num.setText(num+"");
                sellerAdapter.notifyDataSetChanged();

            }
        });
        doHttp();
    }

    private void doHttp() {
        new HttpUtil().get("product/getCarts?uid=71",null).result(new HttpUtil.HttpListener() {
            @Override
            public void success(String data) {
                GoodBean goodBean = new Gson().fromJson(data, GoodBean.class);
                data1 = goodBean.getData();
                data1.remove(0);
                sellerAdapter.setList(data1);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recycle_home.setLayoutManager(linearLayoutManager);
                recycle_home.setAdapter(sellerAdapter);
//                toast(data1.toString());
            }

            @Override
            public void fail(String error) {

            }
        });
    }

    private Context context;
    @Override
    public void setContext(Context context) {
        super.setContext(context);
        this.context=context;

    }

    public void initView(RecyclerView recycle_home) {
        this.recycle_home=recycle_home;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.quan:
                int num=0;
                double price=0;
                boolean checked = quan.isChecked();

                for (int i=0;i<data1.size();i++){
                    List<GoodBean.DataBean.ListBean> list = data1.get(i).getList();
                    for (int j=0;j<list.size();j++){
                        list.get(j).setIscheck(checked);
                        num+=list.get(j).getNum();
                        price+=list.get(j).getPrice()*list.get(j).getNum();
                    }
                    data1.get(i).setIscheck(checked);
                }
                if (checked) {
                    tv_now_price.setText("总价:"+price);
                    btn_now_num.setText(num+"");
                }else{
                    tv_now_price.setText("总价:");
                    btn_now_num.setText("结算");
                }
                sellerAdapter.notifyDataSetChanged();
                break;
        }
    }


}
