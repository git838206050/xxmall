package cn.lcy.xxmall.pojo;

public class BgImage {
    private Integer id;

    private String imageurl;

    private String imageencrypt;

    private Integer usenum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl == null ? null : imageurl.trim();
    }

    public String getImageencrypt() {
        return imageencrypt;
    }

    public void setImageencrypt(String imageencrypt) {
        this.imageencrypt = imageencrypt == null ? null : imageencrypt.trim();
    }

    public Integer getUsenum() {
        return usenum;
    }

    public void setUsenum(Integer usenum) {
        this.usenum = usenum;
    }
}