package cn.lcy.xxmall.pojo;

public class Shop {
    private Integer id;

    private Integer userid;

    private String name;

    private String address;

    private Byte state;

    private Integer level;

    private String decoratecontent;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDecoratecontent() {
        return decoratecontent;
    }

    public void setDecoratecontent(String decoratecontent) {
        this.decoratecontent = decoratecontent == null ? null : decoratecontent.trim();
    }
}