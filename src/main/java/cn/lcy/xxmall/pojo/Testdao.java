package cn.lcy.xxmall.pojo;

public class Testdao {
    private Integer id;

    private String testname;

    private Integer testtype;

    private Integer testtype2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname == null ? null : testname.trim();
    }

    public Integer getTesttype() {
        return testtype;
    }

    public void setTesttype(Integer testtype) {
        this.testtype = testtype;
    }

    public Integer getTesttype2() {
        return testtype2;
    }

    public void setTesttype2(Integer testtype2) {
        this.testtype2 = testtype2;
    }
}