package cn.lcy.xxmall.pojo;

import java.util.Date;

public class Advertisement {
    private Integer id;

    private Integer shopid;

    private String advertname;

    private String headerurl;

    private Double width;

    private Double height;

    private Byte isfixedshow;

    private String showurlposition;

    private Date creattime;

    private Date expiretime;

    private String imageurl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public String getAdvertname() {
        return advertname;
    }

    public void setAdvertname(String advertname) {
        this.advertname = advertname == null ? null : advertname.trim();
    }

    public String getHeaderurl() {
        return headerurl;
    }

    public void setHeaderurl(String headerurl) {
        this.headerurl = headerurl == null ? null : headerurl.trim();
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Byte getIsfixedshow() {
        return isfixedshow;
    }

    public void setIsfixedshow(Byte isfixedshow) {
        this.isfixedshow = isfixedshow;
    }

    public String getShowurlposition() {
        return showurlposition;
    }

    public void setShowurlposition(String showurlposition) {
        this.showurlposition = showurlposition == null ? null : showurlposition.trim();
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public Date getExpiretime() {
        return expiretime;
    }

    public void setExpiretime(Date expiretime) {
        this.expiretime = expiretime;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }
}