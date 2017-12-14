package cn.lcy.xxmall.pojo;

public class SalesPropertyValue {
    private Integer id;

    private Integer productid;

    private Integer propertykeyid;

    private String propertyvalue;

    private Byte showtype;

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

    public Integer getPropertykeyid() {
        return propertykeyid;
    }

    public void setPropertykeyid(Integer propertykeyid) {
        this.propertykeyid = propertykeyid;
    }

    public String getPropertyvalue() {
        return propertyvalue;
    }

    public void setPropertyvalue(String propertyvalue) {
        this.propertyvalue = propertyvalue == null ? null : propertyvalue.trim();
    }

    public Byte getShowtype() {
        return showtype;
    }

    public void setShowtype(Byte showtype) {
        this.showtype = showtype;
    }
}