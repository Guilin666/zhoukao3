package bwie.example.com.guilin20181119.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import bwie.example.com.guilin20181119.R;
import bwie.example.com.guilin20181119.model.DataBean;

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.MyViewHolder> {
    private Context context;
    private  List<DataBean> list=new ArrayList<>();
    public ShowAdapter(Context context) {
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = View.inflate(context, R.layout.show_layout, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.show_img.setImageURI(list.get(i).getImage().split("\\|")[0]);
        myViewHolder.show_title.setText(list.get(i).getTitle());
    }

    @Override
    public int getItemCount() {

        return list.size();
    }


    public void setList(List<DataBean> list) {
        this.list = list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView show_img;
        TextView show_title;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            show_img=itemView.findViewById(R.id.show_img);
            show_title=itemView.findViewById(R.id.show_title);
        }
    }
}
