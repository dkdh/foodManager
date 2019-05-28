package foodmanager.domain.model;

//import java.io.Serializable;


public class User/* implements Serializable*/{
	
	private int userId;
	
	private String password;
	
	private String userName;
	
	private int havingFood;
	
	private String grant;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public int getHavingFood() {
		return havingFood;
	}

	public void setHavingFood(int havingFood) {
		this.havingFood = havingFood;
	}

	public String getGrant() {
		return grant;
	}

	public void setGrant(String grant) {
		this.grant = grant;
	}
}