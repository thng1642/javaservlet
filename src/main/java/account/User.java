package account;

import java.io.Serializable;

public class User implements Serializable {
	private String mssv;
	private String name;
	
	public User() {
		this.mssv = "";
		this.name = "";
	}
	public User(String mssv, String name) {
		this.mssv = mssv;
		this.name = name;
	}
	
	public void setMssv(String mssv) {
		this.mssv = mssv;
	}
	public String getMssv() {
		return this.mssv;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
}
