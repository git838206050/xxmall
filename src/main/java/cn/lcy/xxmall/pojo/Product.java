package cn.lcy.xxmall.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private Integer id;

    private Integer producttypeid;

    private Integer shopid;

    private Integer uploaduserid;

    private String productname;

    private Date creattime;

    private Byte productstate;

    private BigDecimal originalprive;

    private BigDecimal discountprive;

    private Integer stock;

    private String describing;

    private String mainimageurl;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProducttypeid() {
        return producttypeid;
    }

    public void setProducttypeid(Integer producttypeid) {
        this.producttypeid = producttypeid;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public Integer getUploaduserid() {
        return uploaduserid;
    }

    public void setUploaduserid(Integer uploaduserid) {
        this.uploaduserid = uploaduserid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public Byte getProductstate() {
        return productstate;
    }

    public void setProductstate(Byte productstate) {
        this.productstate = productstate;
    }

    public BigDecimal getOriginalprive() {
        return originalprive;
    }

    public void setOriginalprive(BigDecimal originalprive) {
        this.originalprive = originalprive;
    }

    public BigDecimal getDiscountprive() {
        return discountprive;
    }

    public void setDiscountprive(BigDecimal discountprive) {
        this.discountprive = discountprive;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescribing() {
        return describing;
    }

    public void setDescribing(String describing) {
        this.describing = describing == null ? null : describing.trim();
    }

    public String getMainimageurl() {
        return mainimageurl;
    }

    public void setMainimageurl(String mainimageurl) {
        this.mainimageurl = mainimageurl == null ? null : mainimageurl.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}