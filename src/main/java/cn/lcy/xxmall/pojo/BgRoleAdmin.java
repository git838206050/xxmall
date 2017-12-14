package cn.lcy.xxmall.pojo;

import java.util.Date;

public class BgRoleAdmin {
    private Integer id;

    private Integer bgroleid;

    private Integer adminid;

    private Date creattime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBgroleid() {
        return bgroleid;
    }

    public void setBgroleid(Integer bgroleid) {
        this.bgroleid = bgroleid;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }
}