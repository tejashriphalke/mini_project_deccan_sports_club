package com.cybage.pojos;

public class Users {

	private int userId;
	private String username;
	private String password ;
	private String role;
	private String address;
	private String phone; 
	private String email;
	public Users() {
		super();
	}
	public Users(int userId, String username, String password, String role, String address, String phone,
			String email) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.role = role;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
	public Users(String username, String password, String role, String address, String phone, String email) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
	public int getUserId() {
		return userId;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", address=" + address + ", phone=" + phone + ", email=" + email + "]";
	}



}
