package kp.bean;

import java.util.Date;

public class UserBean {
    private Integer uid;

    private String role;

    private String email;

    private String nick;

    private String pass;

    private Date dates;

    private String name;

    private String phone;

    private String addr;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick == null ? null : nick.trim();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

	public UserBean(Integer uid, String role, String email, String nick,
			String pass, Date dates, String name, String phone, String addr) {
		super();
		this.uid = uid;
		this.role = role;
		this.email = email;
		this.nick = nick;
		this.pass = pass;
		this.dates = dates;
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}

}