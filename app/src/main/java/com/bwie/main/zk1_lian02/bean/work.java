package com.bwie.main.zk1_lian02.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by admin on 2018/9/2.
 */
@Entity
public class work {
    @Id(autoincrement = true)
    Long id;
    @Property
    String imgurl;
    @Property
    String title1;
    @Generated(hash = 1221528150)
    public work(Long id, String imgurl, String title1) {
        this.id = id;
        this.imgurl = imgurl;
        this.title1 = title1;
    }
    @Generated(hash = 1240973331)
    public work() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImgurl() {
        return this.imgurl;
    }
    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
    public String getTitle1() {
        return this.title1;
    }
    public void setTitle1(String title1) {
        this.title1 = title1;
    }

}
