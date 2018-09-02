package com.bwie.main.zk1_lian02.mvp;

import android.util.Log;

import com.bwie.main.zk1_lian02.bean.work;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by admin on 2018/9/2.
 */

public class presenterimp implements icontract.ipresebnter<icontract.iview>{

    private WeakReference<icontract.iview> iviewWeakReference;
    private  icontract.iview iview;
    private moudleimp moudleimp;
    private WeakReference<icontract.imoudle> weakReference;

    @Override
    public void attachview(icontract.iview iview) {
        this.iview = iview;
        moudleimp = new moudleimp();
        //创建弱引用
        iviewWeakReference = new WeakReference<>(iview);
        weakReference = new WeakReference<icontract.imoudle>(moudleimp);
    }

    @Override
    public void detachview(icontract.iview iview) {
        //取消关联
        iviewWeakReference.clear();
        weakReference.clear();
    }

    @Override
    public void requestinfo() {
        //接口回调
        moudleimp.requestdata(new icontract.imoudle.oncalllisten() {
            @Override
            public void responsemsg(List<work> works) {
                //v层里面的方法
                iview.showdata(works);
                Log.i("xxx",works+"");
            }
        });
    }
}
