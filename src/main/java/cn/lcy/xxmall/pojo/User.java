package cn.lcy.xxmall.pojo;

import java.util.Date;

public class User {
    private Integer id;

    private String username;

    private String password;

    private String headerurl;

    private String nickname;

    private String email;

    private Date creattime;

    private Integer storeid;

    private Integer level;

    private Byte recovery;

    private String question;

    private String answer;

    private Date prohibitlogintime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getHeaderurl() {
        return headerurl;
    }

    public void setHeaderurl(String headerurl) {
        this.headerurl = headerurl == null ? null : headerurl.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public Integer getStoreid() {
        return storeid;
    }

    public void setStoreid(Integer storeid) {
        this.storeid = storeid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Byte getRecovery() {
        return recovery;
    }

    public void setRecovery(Byte recovery) {
        this.recovery = recovery;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Date getProhibitlogintime() {
        return prohibitlogintime;
    }

    public void setProhibitlogintime(Date prohibitlogintime) {
        this.prohibitlogintime = prohibitlogintime;
    }
}