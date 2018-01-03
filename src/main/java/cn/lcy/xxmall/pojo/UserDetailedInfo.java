package cn.lcy.xxmall.pojo;

import java.math.BigDecimal;

public class UserDetailedInfo {
    private Integer id;

    private Integer userid;

    private BigDecimal remainingfund;

    private BigDecimal consumptionfund;

    private String defaultaddress;

    private String phonenumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public BigDecimal getRemainingfund() {
        return remainingfund;
    }

    public void setRemainingfund(BigDecimal remainingfund) {
        this.remainingfund = remainingfund;
    }

    public BigDecimal getConsumptionfund() {
        return consumptionfund;
    }

    public void setConsumptionfund(BigDecimal consumptionfund) {
        this.consumptionfund = consumptionfund;
    }

    public String getDefaultaddress() {
        return defaultaddress;
    }

    public void setDefaultaddress(String defaultaddress) {
        this.defaultaddress = defaultaddress == null ? null : defaultaddress.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }
}