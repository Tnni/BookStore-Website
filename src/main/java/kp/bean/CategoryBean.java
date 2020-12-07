package kp.bean;

public class CategoryBean {
    private Integer cid;

    private String name;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	public CategoryBean(Integer cid, String name) {
		super();
		this.cid = cid;
		this.name = name;
	}

}