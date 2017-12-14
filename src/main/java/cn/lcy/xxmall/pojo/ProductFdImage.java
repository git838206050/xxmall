package cn.lcy.xxmall.pojo;

import java.util.Date;

public class ProductFdImage {
    private Integer id;

    private Integer productid;

    private Integer imageid;

    private Byte imagetype;

    private Date creattime;

    private Integer ordernum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getImageid() {
        return imageid;
    }

    public void setImageid(Integer imageid) {
        this.imageid = imageid;
    }

    public Byte getImagetype() {
        return imagetype;
    }

    public void setImagetype(Byte imagetype) {
        this.imagetype = imagetype;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }
}