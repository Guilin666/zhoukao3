package bwie.example.com.guilin20181119.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import bwie.example.com.guilin20181119.R;
import bwie.example.com.guilin20181119.activity.WebActivity;
import bwie.example.com.guilin20181119.mvp.view.DegateImpl;
import bwie.example.com.guilin20181119.view.GoodView;

public class SearchActivityPresenter extends DegateImpl implements View.OnClickListener {
    private List<String> mDatas=new ArrayList<>();
    private List<String> mNowDatas=new ArrayList<>();
    private GoodView goodview;
    private Button btn_sou;
    private EditText ed_message;
    private GoodView goodview2;

    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void iniData() {
        super.iniData();
        mDatas.add("洗衣液");
        mDatas.add("洗衣液");
        mDatas.add("洗衣液");
        mDatas.add("洗衣液");
        btn_sou = (Button)get(R.id.btn_sou);
        ed_message = (EditText)get(R.id.ed_message);
        setOnclick(this,R.id.btn_sou);

        goodview = (GoodView)get(R.id.goodview);
        goodview2 = (GoodView)get(R.id.goodview2);
        goodview.setList(mDatas);
        goodview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,WebActivity.class));
            }
        });

        goodview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,WebActivity.class));
            }
        });


    }

    private Context context;
    @Override
    public void setContext(Context context) {
        super.setContext(context);
        this.context=context;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_sou:
                String message = ed_message.getText().toString().trim();
                if (TextUtils.isEmpty(message)) {
                    toast("不能为空");
                    return;
                }
                mNowDatas.add(message);
                goodview2.setList(mNowDatas);
                break;
        }
    }
}
