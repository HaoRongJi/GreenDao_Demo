package com.bwie.main.zk1_lian02.fragment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.main.zk1_lian02.R;
import com.bwie.main.zk1_lian02.adapter.myadapter;
import com.bwie.main.zk1_lian02.bean.work;
import com.bwie.main.zk1_lian02.mvp.icontract;
import com.bwie.main.zk1_lian02.mvp.presenterimp;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Fragment1 extends Fragment implements icontract.iview{

    @BindView(R.id.recycleview)
    RecyclerView recycleview;
    Unbinder unbinder;
    private presenterimp presenterimp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment1,container,false);
        unbinder = ButterKnife.bind(this, view);
        presenterimp = new presenterimp();
        presenterimp.attachview(this);
        presenterimp.requestinfo();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        presenterimp.detachview(this);
    }

    @Override
    public void showdata(final List<work> works) {
        //强制切回主线程
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //创建布局管理器
                GridLayoutManager manager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
                //添加布局管理器
                recycleview.setLayoutManager(manager);
                //创建适配器
                myadapter myadapter = new myadapter(getActivity(),works);
                //添加适配器
                recycleview.setAdapter(myadapter);
            }
        });
    }
}
