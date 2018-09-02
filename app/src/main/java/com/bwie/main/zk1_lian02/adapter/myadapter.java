package com.bwie.main.zk1_lian02.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.main.zk1_lian02.R;
import com.bwie.main.zk1_lian02.bean.work;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by admin on 2018/9/2.
 */

public class myadapter extends RecyclerView.Adapter<myadapter.oneholder>{

    private Context context;
    private List<work> list;

    public myadapter(Context context, List<work> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public oneholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.include1, null);
        //创建对象
        oneholder oneholder = new oneholder(view);
        return oneholder;
    }

    @Override
    public void onBindViewHolder(@NonNull oneholder holder, int position) {
        holder.bt.setText(list.get(position).getTitle1());
        //获取路径
        Uri uri = Uri.parse(list.get(position).getImgurl());
        //设置图片
        holder.my_image_view.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //创建类
    class oneholder extends RecyclerView.ViewHolder{

        private final TextView bt;
        private final SimpleDraweeView my_image_view;

        public oneholder(View itemView) {
            super(itemView);
            //创建视图
            bt = itemView.findViewById(R.id.bt);
            my_image_view = itemView.findViewById(R.id.my_image_view);
        }
    }

}
