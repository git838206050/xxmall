package cn.lcy.xxmall.pojo;

public class FdImage {
    private Integer id;

    private String imageurl;

    private String imageencrype;

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

    public String getImageencrype() {
        return imageencrype;
    }

    public void setImageencrype(String imageencrype) {
        this.imageencrype = imageencrype == null ? null : imageencrype.trim();
    }

    public Integer getUsenum() {
        return usenum;
    }

    public void setUsenum(Integer usenum) {
        this.usenum = usenum;
    }
}