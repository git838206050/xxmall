package cn.lcy.xxmall.pojo;

import java.util.Date;

public class ProductSku {
    private Integer id;

    private Integer productid;

    private String propertykey;

    private String propertyvaluegroup;

    private Date creattime;

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

    public String getPropertykey() {
        return propertykey;
    }

    public void setPropertykey(String propertykey) {
        this.propertykey = propertykey == null ? null : propertykey.trim();
    }

    public String getPropertyvaluegroup() {
        return propertyvaluegroup;
    }

    public void setPropertyvaluegroup(String propertyvaluegroup) {
        this.propertyvaluegroup = propertyvaluegroup == null ? null : propertyvaluegroup.trim();
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }
}