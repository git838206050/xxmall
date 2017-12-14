package cn.lcy.xxmall.pojo;

import java.util.Date;

public class Admin {
    private Integer id;

    private String adminname;

    private String password;

    private String nickname;

    private Date creattime;

    private Date lasttime;

    private String email;

    private String headerurl;

    private Date prohibitlogintime;

    private Byte recovery;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname == null ? null : adminname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public Date getLasttime() {
        return lasttime;
    }

    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getHeaderurl() {
        return headerurl;
    }

    public void setHeaderurl(String headerurl) {
        this.headerurl = headerurl == null ? null : headerurl.trim();
    }

    public Date getProhibitlogintime() {
        return prohibitlogintime;
    }

    public void setProhibitlogintime(Date prohibitlogintime) {
        this.prohibitlogintime = prohibitlogintime;
    }

    public Byte getRecovery() {
        return recovery;
    }

    public void setRecovery(Byte recovery) {
        this.recovery = recovery;
    }
}