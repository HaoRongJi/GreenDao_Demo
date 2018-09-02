package com.bwie.main.zk1_lian02.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.bwie.main.zk1_lian02.R;
import com.bwie.main.zk1_lian02.fragment.Fragment1;
import com.bwie.main.zk1_lian02.fragment.Fragment2;
import com.bwie.main.zk1_lian02.fragment.Fragment3;
import com.bwie.main.zk1_lian02.fragment.Fragment4;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fram_layout)
    FrameLayout frameLayout;
    private FragmentManager manager;
    private RadioGroup rap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        rap = findViewById(R.id.rap);
        //创建对象
        final Fragment1 fragment1 = new Fragment1();
        final Fragment2 fragment2 = new Fragment2();
        final Fragment3 fragment3 = new Fragment3();
        final Fragment4 fragment4 = new Fragment4();
        //创建默认提交事务
        manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fram_layout,fragment1).commit();
        rap.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                FragmentTransaction transaction = manager.beginTransaction();
                switch (i){
                    case R.id.rap1:
                        transaction.replace(R.id.fram_layout,fragment1);
                        break;
                    case R.id.rap2:
                        transaction.replace(R.id.fram_layout,fragment2);
                        break;
                    case R.id.rap3:
                        transaction.replace(R.id.fram_layout,fragment3);
                        break;
                    case R.id.rap4:
                        transaction.replace(R.id.fram_layout,fragment4);
                        break;
                }
                //提交事务
                transaction.commit();
            }
        });
    }
}
