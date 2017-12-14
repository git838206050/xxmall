package cn.lcy.xxmall.pojo;

import java.util.Date;

public class BgRolePurview {
    private Integer id;

    private Integer bgroleid;

    private Integer bgpurviewid;

    private Date createtime;

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

    public Integer getBgpurviewid() {
        return bgpurviewid;
    }

    public void setBgpurviewid(Integer bgpurviewid) {
        this.bgpurviewid = bgpurviewid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}