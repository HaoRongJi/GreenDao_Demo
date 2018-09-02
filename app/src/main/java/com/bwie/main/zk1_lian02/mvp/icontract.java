package com.bwie.main.zk1_lian02.mvp;

import com.bwie.main.zk1_lian02.bean.work;

import java.util.List;

/**
 * Created by admin on 2018/9/2.
 */

public interface icontract {
    //iview层
    public interface iview{
        void showdata(List<work> works);
    }
    //imoudle层
    public interface imoudle{
        //接口
        public interface oncalllisten{
            //请求方法
            void responsemsg(List<work> works);
        }
        //方法
        void requestdata(oncalllisten oncalllisten);
    }
    //ipresebnter层
    public interface ipresebnter<iview>{
        //关联
        void attachview(iview iview);
        //取消
        void detachview(iview iview);
        //逻辑方法
        void requestinfo();
    }
}
