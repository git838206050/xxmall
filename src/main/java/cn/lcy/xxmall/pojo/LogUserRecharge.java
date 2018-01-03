package cn.lcy.xxmall.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class LogUserRecharge {
    private Integer id;

    private Integer userid;

    private BigDecimal rechargenumber;

    private Date creattime;

    private Byte rechargestate;

    private String userip;

    private String paymentvoucher;

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

    public BigDecimal getRechargenumber() {
        return rechargenumber;
    }

    public void setRechargenumber(BigDecimal rechargenumber) {
        this.rechargenumber = rechargenumber;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public Byte getRechargestate() {
        return rechargestate;
    }

    public void setRechargestate(Byte rechargestate) {
        this.rechargestate = rechargestate;
    }

    public String getUserip() {
        return userip;
    }

    public void setUserip(String userip) {
        this.userip = userip == null ? null : userip.trim();
    }

    public String getPaymentvoucher() {
        return paymentvoucher;
    }

    public void setPaymentvoucher(String paymentvoucher) {
        this.paymentvoucher = paymentvoucher == null ? null : paymentvoucher.trim();
    }
}