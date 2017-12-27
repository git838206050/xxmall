package cn.lcy.xxmall.pojo;

import java.util.Date;

public class LogUserRecharge {
    private Integer id;

    private Integer userid;

    private Long rechargenumber;

    private Date creattime;

    private String rechargestate;

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

    public Long getRechargenumber() {
        return rechargenumber;
    }

    public void setRechargenumber(Long rechargenumber) {
        this.rechargenumber = rechargenumber;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public String getRechargestate() {
        return rechargestate;
    }

    public void setRechargestate(String rechargestate) {
        this.rechargestate = rechargestate == null ? null : rechargestate.trim();
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