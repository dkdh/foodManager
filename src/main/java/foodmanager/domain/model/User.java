package foodmanager.domain.model;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 7712653790927881497L;
	
	private String password;
	
	private String userName;
	
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setName(String userName) {
		this.userName = userName;
	}

}