package cn.lcy.xxmall.pojo;

public class DbaProduct {
    private Integer id;

    private Integer prodictid;

    private String keyword;

    private Byte priority;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProdictid() {
        return prodictid;
    }

    public void setProdictid(Integer prodictid) {
        this.prodictid = prodictid;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public Byte getPriority() {
        return priority;
    }

    public void setPriority(Byte priority) {
        this.priority = priority;
    }
}