package bwie.example.com.guilin20181119.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bwie.example.com.guilin20181119.R;
import bwie.example.com.guilin20181119.model.GoodBean;

public class SellerAdapter extends RecyclerView.Adapter<SellerAdapter.MyViewHolder> {
    private Context context;
    private List<GoodBean.DataBean> list=new ArrayList<>();

    public SellerAdapter(Context context) {
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.seller_layout, null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.tv_seller.setText(list.get(i).getSellerName());
        GoodAdapter goodAdapter = new GoodAdapter(context,list.get(i).getList());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myViewHolder.reclcye_seller.setLayoutManager(linearLayoutManager);
        myViewHolder.reclcye_seller.setAdapter(goodAdapter);
        myViewHolder.seller_xuan.setChecked(list.get(i).isIscheck());
        goodAdapter.setGoodListener(new GoodAdapter.GoodListener() {
            @Override
            public void goodChange() {
                listener.sellerChange(list);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<GoodBean.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_seller;
        RecyclerView reclcye_seller;
        CheckBox seller_xuan;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_seller=itemView.findViewById(R.id.tv_seller);
            reclcye_seller=itemView.findViewById(R.id.reclcye_seller);
            seller_xuan=itemView.findViewById(R.id.seller_xuan);
        }
    }

    private SellerListener listener;
    public void setSellerListener(SellerListener listener){
        this.listener=listener;

    }

    public interface  SellerListener{
        void sellerChange(List<GoodBean.DataBean> list);
    }
}
