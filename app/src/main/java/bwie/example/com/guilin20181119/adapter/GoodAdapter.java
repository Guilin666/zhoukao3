package bwie.example.com.guilin20181119.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import bwie.example.com.guilin20181119.R;
import bwie.example.com.guilin20181119.model.DataBean;
import bwie.example.com.guilin20181119.model.GoodBean;
import bwie.example.com.guilin20181119.utils.GreenSqlUtils;

public class GoodAdapter extends RecyclerView.Adapter<GoodAdapter.MyViewHolder> {
    private  List<GoodBean.DataBean.ListBean> list=new ArrayList<>();
    private Context context;
    private GreenSqlUtils greenSqlUtils;

    public GoodAdapter(Context context, List<GoodBean.DataBean.ListBean> list) {
        this.context=context;
        this.list=list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.good_layout, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        greenSqlUtils = new GreenSqlUtils(context);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
        myViewHolder.good_price.setText(list.get(i).getPrice()+"");
        myViewHolder.good_title.setText(list.get(i).getTitle());
        myViewHolder.tv_num.setText(list.get(i).getNum()+"");
        myViewHolder.sim_good.setImageURI(list.get(i).getImages().split("\\|")[0]);
        //全选
        myViewHolder.xuan.setChecked(list.get(i).isIscheck());


        myViewHolder.sim_good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBean dataBean = new DataBean();
                dataBean.setImage(list.get(i).getImages());
                dataBean.setTitle(list.get(i).getTitle());
                greenSqlUtils.insert(dataBean);//添加

            }
        });

        //将选中变为不选中
        myViewHolder.xuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list.get(i).isIscheck()) {
                    list.get(i).setIscheck(false);
                }else{
                    list.get(i).setIscheck(true);
                }

                listener.goodChange();
                notifyItemChanged(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView good_price;
        TextView good_title;
        TextView tv_num;
        SimpleDraweeView sim_good;
        CheckBox xuan;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            good_price=itemView.findViewById(R.id.good_price);
            good_title=itemView.findViewById(R.id.good_title);
            sim_good=itemView.findViewById(R.id.sim_good);
            xuan= itemView.findViewById(R.id.xuan);
            tv_num=itemView.findViewById(R.id.tv_num);
        }
    }


    private GoodListener listener;
    public void setGoodListener(GoodListener listener){
        this.listener=listener;
    }
    public interface GoodListener{
        void goodChange();
    }
}
