package cn.lcy.xxmall.pojo;

public class PageMessage {
    private Integer id;

    private String messagekey;

    private String messagevalue;

    private String code;

    private String brief;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessagekey() {
        return messagekey;
    }

    public void setMessagekey(String messagekey) {
        this.messagekey = messagekey == null ? null : messagekey.trim();
    }

    public String getMessagevalue() {
        return messagevalue;
    }

    public void setMessagevalue(String messagevalue) {
        this.messagevalue = messagevalue == null ? null : messagevalue.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }
}