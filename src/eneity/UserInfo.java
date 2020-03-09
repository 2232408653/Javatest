package eneity;

public class UserInfo {
	String uname;
	String upwd;
	String upower;
	String upass;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUpower() {
		return upower;
	}
	public void setUpower(String upower) {
		this.upower = upower;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	@Override
	public String toString() {
		return "UserInfo [uname=" + uname + ", upwd=" + upwd + ", upower=" + upower + ", upass=" + upass + "]";
	}
	
}
